package com.company;

public class Main {

    public static void main(String[] args) {
        RobinKarp robinKarp = new RobinKarp("abcdef", "abcdefghij");
        robinKarp.Search();
        robinKarp = new RobinKarp("abab", "abcdefghij");
        robinKarp.Search();
        robinKarp = new RobinKarp("ababzxc", "abcdefghij");
        robinKarp.Search();
    }
}
