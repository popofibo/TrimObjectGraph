/**
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE Version 2, December 2004
 * 
 * Copyright (C) 2014 http://popofibo.com <popo.fibo@gmail.com>
 * 
 * Everyone is permitted to copy and distribute verbatim or modified copies of
 * this code, and changing it is allowed as long as the name is changed.
 * 
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE TERMS AND CONDITIONS FOR COPYING,
 * DISTRIBUTION AND MODIFICATION
 * 
 * 0. You just DO WHAT THE FUCK YOU WANT TO.
 * 
 */
package com.popofibo.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Build complex object graph to test the trim of String properties
 * 
 * @author popofibo
 */
public class SpaceTest {

	private static Music music = new Music();

	/**
	 * Build the complex object graph
	 * 
	 * @return
	 */
	public static Music buildObj() {
		Song song1 = new Song();
		Song song2 = new Song();
		Song song3 = new Song();

		Artist artist1 = new Artist();
		Artist artist2 = new Artist();

		song1.setGenre("ROCK       ");
		song1.setSonnet("X    ");
		song1.setNotes("Y    ");
		song1.setCompostions(Arrays.asList(new String[] { "SOME X DATA  ",
				"SOME OTHER DATA X ", "SOME MORE DATA X    ", " " }));

		Set<String> instruments = new HashSet<String>();
		instruments.add("         GUITAR    ");
		instruments.add("         SITAR    ");
		instruments.add("         DRUMS    ");
		instruments.add("         BASS    ");

		song1.setInstruments(instruments);

		song2.setGenre("METAL       ");
		song2.setSonnet("A    ");
		song2.setNotes("B    ");
		song2.setCompostions(Arrays.asList(new String[] { "SOME Y DATA  ",
				"          SOME OTHER DATA Y ",
				"           SOME MORE DATA Y    ", " " }));

		song3.setGenre("POP       ");
		song3.setSonnet("DONT    ");
		song3.setNotes("KNOW     ");
		song3.setCompostions(Arrays.asList(new String[] { "SOME Z DATA  ",
				"               SOME OTHER DATA Z ",
				"          SOME MORE DATA Z   ", " " }));

		artist1.setSongList(Arrays.asList(new Song[] { song1, song3 }));

		artist2.setSongList(Arrays.asList(new Song[] { song1, song2, song3 }));
		Map<String, Person> artistMap = new HashMap<String, Person>();
		Person tutor1 = new Person();
		tutor1.setName("JOHN JACKSON DOE       ");
		artistMap.put("          Name                 ", tutor1);

		Person coach1 = new Person();
		coach1.setName("CARTER	 ");
		artistMap.put("Coach      ", coach1);
		artist2.setTutor(artistMap);

		music.setSongs(Arrays.asList(new Song[] { song1, song2, song3 }));
		music.setArtists(Arrays.asList(new Artist[] { artist1, artist2 }));

		music.setLanguages(new String[] { "    ENGLISH    ", "FRENCH    ",
				"HINDI    " });
		Person singer1 = new Person();
		singer1.setName("DAVID      ");

		Person singer2 = new Person();
		singer2.setName("JACOB      ");
		music.setSingers(new Person[] { singer1, singer2 });

		Human man = new Human();
		Person p = new Person();
		p.setName("   JACK'S RAGING BULL   ");
		SomeGuy m = new SomeGuy();
		m.setPerson(p);
		man.setMan(m);

		music.setHuman(man);

		return music;
	}

	/**
	 * Main method to test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Test with a complex Object graph
			buildObj();

			System.out.println("#######BEFORE#######");
			System.out.println(music);
			System.out.println("Number of spaces : "
					+ (music.toString().split("\\s").length - 1));
			music = (Music) SpaceUtil.trimReflective(music);
			System.out.println("#######AFTER#######");
			System.out.println(music);
			System.out.println("Number of spaces : "
					+ (music.toString().split("\\s").length - 1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Music {
	private Person[] singers;
	private String[] languages;
	private Human human;

	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public Person[] getSingers() {
		return singers;
	}

	public void setSingers(Person[] singers) {
		this.singers = singers;
	}

	private List<Song> songs;

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public List<Artist> getArtists() {
		return artist;
	}

	public void setArtists(List<Artist> artist) {
		this.artist = artist;
	}

	private List<Artist> artist;

	@Override
	public String toString() {
		String str = ">>"
				+ (this.singers != null ? Arrays.asList(this.singers) : "")
				+ "---"
				+ (this.languages != null ? Arrays.asList(this.languages) : "")
				+ "---" + (this.songs != null ? this.songs : "") + "---"
				+ (this.artist != null ? this.artist : "") + "---"
				+ (this.human != null ? this.human : "") + "<<";
		return str;
	}
}

class Song {
	private Set<String> instruments;

	public Set<String> getInstruments() {
		return instruments;
	}

	public void setInstruments(Set<String> instruments) {
		this.instruments = instruments;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSonnet() {
		return sonnet;
	}

	public void setSonnet(String sonnet) {
		this.sonnet = sonnet;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<String> getCompostions() {
		return compositions;
	}

	public void setCompostions(List<String> compositions) {
		this.compositions = compositions;
	}

	private String genre;
	private String sonnet;
	private String notes;
	private List<String> compositions;

	@Override
	public String toString() {
		String str = ">>" + (this.genre != null ? this.genre : "") + "---"
				+ (this.sonnet != null ? this.sonnet : "") + "---"
				+ (this.notes != null ? this.notes : "") + "---"
				+ (this.compositions != null ? this.compositions : "") + "---"
				+ (this.instruments != null ? this.instruments : "") + "<<";
		return str;
	}
}

class Artist {
	private Map<String, Person> tutor;

	public Map<String, Person> gettutor() {
		return tutor;
	}

	public void setTutor(Map<String, Person> tutor) {
		this.tutor = tutor;
	}

	public List<Song> getSongList() {
		return songList;
	}

	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}

	private List<Song> songList;

	@Override
	public String toString() {
		String str = ">>" + (this.tutor != null ? this.tutor : "") + "---"
				+ (this.songList != null ? this.songList : "") + "<<";
		return str;
	}
}

class Person {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	private String name;
	private String age;

	@Override
	public String toString() {
		String str = ">>" + (this.name != null ? this.name : "") + "---"
				+ (this.age != null ? this.age : "") + "<<";
		return str;
	}
}

class Human {
	private SomeGuy man;

	public SomeGuy getMan() {
		return man;
	}

	public void setMan(SomeGuy man) {
		this.man = man;
	}

	@Override
	public String toString() {
		return "=>" + this.getMan().getPerson().getName() + "<=";
	}
}

class SomeGuy {
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return this.person.getName();
	}
}
