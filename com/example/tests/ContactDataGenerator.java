package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;



public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Specify params: <amount> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exist " +file);
			return;
		}

		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("unknown format" + format);
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts); 
		FileWriter writer = new FileWriter(file); 
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file); 
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file); 
		for (ContactData contact : contacts) {
			writer.write(contact.getContactName() + "," + contact.getContactLastName() +","+contact.getAddress() + ","+contact.getEmail_1() +
					","+contact.getHomePhone() + ","+contact.getSecAddr() + ","+contact.getSecHomeAddr() + ","+contact.getBirhDay() +",!"+ "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException  {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		bufferedReader.readLine();
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
			.withContactName(part[0])
			.withContactLastName(part[1])
			.withAddress(part[2])
			.withEmail_1(part[3])
			.withHomePhone(part[4])
			.withSecAddr(part[5])
			.withSecHomeAddr(part[6])
			.withBirthYear(part[7]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
			ContactData contact = new ContactData()
			.withContactName(generateRandomString())
			.withContactLastName(generateRandomString())
			.withAddress(generateRandomString())
			.withEmail_1(generateRandomString())
			.withHomePhone(generateRandomString())
			.withSecAddr(generateRandomString())
			.withSecHomeAddr(generateRandomString())
			.withBirthYear(generateRandomYear());
			list.add(contact);
		}
		return list;
	}

	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}

	}
	public static String generateRandomYear() {
		int t = ((int) (Math.random() * 9999 + 1));
		String a = Integer.toString(t);
		return a;
	}
}