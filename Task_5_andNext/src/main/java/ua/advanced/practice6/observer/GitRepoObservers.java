package ua.advanced.practice6.observer;

import ua.advanced.practice6.MyLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class GitRepoObservers {
    private static List<WebHook> webHooks = new ArrayList<>();
    private static List<Event> events = new ArrayList<>();

    public static Repository newRepository() {
        MyLogger.logger.log(Level.CONFIG,"Create new Repository");
        return new Repository() {
            @Override
            public void addWebHook(WebHook webHook) {
                if(webHooks.stream().noneMatch(x->x.branch().equals(webHook.branch())&&x.type().equals(webHook.type()))) {
                    webHooks.add(webHook);
                }
            }

            @Override
            public Commit commit(String branch, String author, String[] changes) {
                MyLogger.logger.log(Level.FINER,"commit : "+"branch="+branch+" Author"+author+" Changes:"+Arrays.toString(changes));
                if(webHooks.stream().anyMatch(x->x.branch().equals(branch))) {
                    events.add(new Event(Event.Type.COMMIT, branch, new ArrayList<Commit>(List.of(new Commit(author, changes)))));
                }
                return new Commit(branch,changes);
            }

            @Override
            public void merge(String sourceBranch, String targetBranch) {
                MyLogger.logger.log(Level.FINER,"Merge repository: "+" source branch: "+sourceBranch+" targetBranch"+targetBranch);
                if(webHooks.stream().anyMatch(x->x.branch().equals(sourceBranch))&&webHooks.stream().anyMatch(x->x.branch().equals(targetBranch)&&x.type().equals(Event.Type.MERGE))) {
                    List<Commit> list = new ArrayList<>();
                    events.stream().filter(x -> x.branch().equals(sourceBranch)&&x.type().equals(Event.Type.COMMIT)).forEach(x -> list.addAll(x.commits()));
                    if(events.stream().noneMatch(x->x.commits().equals(list)&&x.branch().equals(targetBranch)))
                    events.add(new Event(Event.Type.MERGE, targetBranch, list));
                }
            }
        };
    }

    public static WebHook mergeToBranchWebHook(String branchName) {
        MyLogger.logger.log(Level.FINER,"mergeToBranchWebHook : "+branchName);
       return new WebHook() {
           @Override
           public String branch() {
               return branchName;
           }

           @Override
           public Event.Type type() {
               return Event.Type.MERGE;
           }

           @Override
           public List<Event> caughtEvents() {
               return events.stream().filter(x->x.branch().equals(branchName)&&x.type().equals(Event.Type.MERGE)).toList();
           }

           @Override
           public void onEvent(Event event) {
               events.add(event);
           }
       };
    }

    public static WebHook commitToBranchWebHook(String branchName) {
        MyLogger.logger.log(Level.FINER,"commitToBranchWebHook : "+branchName);
        return new WebHook() {
            @Override
            public String branch() {
                return branchName;
            }

            @Override
            public Event.Type type() {
                return Event.Type.COMMIT;
            }

            @Override
            public List<Event> caughtEvents() {
                return events.stream().filter(x->x.branch().equals(branchName)&&x.type().equals(Event.Type.COMMIT)).toList();
            }

            @Override
            public void onEvent(Event event) {
                    events.add(event);
            }
        };
    }
}
