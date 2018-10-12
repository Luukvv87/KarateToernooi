package Vrijdag1210;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

class Demo{
	public static void main(String[] args) {
		System.out.println("Leuk dat je een tournooi organiseert. \n Hoe heet je tournooi?");
		Scanner scanner = new Scanner(System.in);
		String naamTournooi = scanner.nextLine();
		Tournooi karateTournooi = new Tournooi();
		karateTournooi.setNaam(naamTournooi);
		karateTournooi.welkom();

		System.out.println("Wil u al mensen aanmelden? \n 1 ja 2 nee");
		int antwoordNogEen = scanner.nextInt();
		if(antwoordNogEen == 1) {
			System.out.println("je hebt 1 gedrukt");
			karateTournooi.voegDeelnemersToe();
		}else {
			System.out.println("wordt een kort tournooi");
		}

		karateTournooi.speelWedstrijd();
		karateTournooi.speelWedstrijd();
		System.out.println("Wat een spanning dames en heren. De finale gaat tussen " + karateTournooi.deelnemers.get(0) + " en " + karateTournooi.deelnemers.get(1));
		karateTournooi.speelWedstrijd();
	}
}
class Tournooi{
	String naam;
	ArrayList<Deelnemer> deelnemers = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	
	void welkom() {
		System.out.println("Welkom bij "+ naam);
	}
	void setNaam(String naam) {
		this.naam = naam;
	}
	void voegDeelnemersToe() {
		
		System.out.print("Wat is uw naam");
		String deNaam = scanner.next();
		Deelnemer deelnemer = new Deelnemer(deNaam);
		deelnemers.add(deelnemer);
		System.out.println("Wilt u nog iemand aanmelden?\n 1 ja 2 nee");
		int antwoordNogEen = scanner.nextInt();
		if(antwoordNogEen == 1) {
			voegDeelnemersToe();
		} else {
			shuffleDeelnemers();
		}
	}
	Deelnemer speelWedstrijd() {
		System.out.println("Lets get ready to rumble");
		System.out.println(deelnemers.get(0).naam + " speelt tegen " + deelnemers.get(1).naam);
		Deelnemer winnaar = deelnemers.get(random.nextInt(2));
		System.out.println("De winnaar is: " + winnaar.naam);
		deelnemers.remove(0);
		deelnemers.remove(0);
		deelnemers.add(deelnemers.size(), winnaar);
		return winnaar;
	}
	void shuffleDeelnemers() {
		Collections.shuffle(deelnemers);
		System.out.println(deelnemers.get(0).naam + " speelt tegen " + deelnemers.get(1).naam);
		System.out.println(deelnemers.get(2).naam + " speelt tegen " + deelnemers.get(3).naam);
		
	}
}
class Deelnemer{
	String naam;
	Deelnemer(String deNaam){
		naam = deNaam;
	}
	@Override
	public String toString() {
		return naam;
	}
}