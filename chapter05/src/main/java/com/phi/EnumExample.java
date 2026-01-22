package com.phi;

public class EnumExample {
	public static void main(String[] args) {
		Genre genre = Genre.ACTION;
		Genre[] genres = new Genre[3];

		System.out.println(genre + "(" + genre.ordinal() + ")");
		for(int i = 0; i < genres.length; i++) {
			genres[i] = Genre.ADVENTURE;
		}
		for(Genre g : genres) {
			System.out.println("genre: " + g + "(" + g.ordinal() + ")");
		}
	}
}
