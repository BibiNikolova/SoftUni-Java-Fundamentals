package objectsAndClasses.src;

import java.util.Scanner;

public class Articles {

    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return this.author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", this.title,
                    this.content, this.author);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(", ");
        String title = data[0];
        String content = data[1];
        String author = data[2];

        Article article = new Article(title, content, author);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split(": ");
            String action = commands[0];
            String change = commands[1];
            if ("Edit".equals(action)) {
                article.setContent(change);
            } else if ("ChangeAuthor".equals(action)) {
                article.setAuthor(change);

            } else if ("Rename".equals(action)) {
                article.setTitle(change);
            }
        }
        System.out.println(article.toString());
    }
}
