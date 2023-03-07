package com.KoreaIT.example.JAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);

		List<Article> articles = new ArrayList();

		int lastArticleId = 0;

		while (true) {
			System.out.printf("명령어 : ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("article write")) {

				System.out.println("== 게시글 작성 ==");
				int id = lastArticleId + 1;
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(id, title, body);
				articles.add(article);
				System.out.println(id + "번 게시글이 생성되었습니다.");
			}

			if (cmd.equals("article list")) {

				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;
				}

				System.out.println("번호 | 제목");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.println(article.id + "    |  " + article.title);
				}
			}
			if(cmd.equals("exit")) {
				System.out.println("== 프로그램 종료 ==");
				break;
			}
		}
		sc.close();
	}
}

class Article {
	int id;
	String title;
	String body;

	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}
