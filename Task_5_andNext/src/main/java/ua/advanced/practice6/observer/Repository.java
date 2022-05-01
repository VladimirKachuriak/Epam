package ua.advanced.practice6.observer;

public interface Repository {
    void addWebHook(WebHook webHook);

    Commit commit(String branch, String author, String[] changes);

    void merge(String sourceBranch, String targetBranch);

}
