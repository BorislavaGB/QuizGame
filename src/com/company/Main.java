package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printCategory();

        String[] geographyQuestions = {
                "Which country is home of the first Olympics?\n" + "1. Greece\n2. France\n3. Germany\n4. England",
                "Which is the largest continent?\n" + "1. Africa\n2. Europe\n3. Asia\n4. Australia",
                "How many islands make up Hawaii?\n" + "1. Five\n2. Six\n3. Seven\n4. Four",
                "Which continent holds most of the worlds' rain forest?\n" + "1. South America\n2. North America\n3. Australia\n4. Europe",
                "Which is the highest peak in the mainland Balkans?\n" + "1. Mount Korab\n2. Vihren\n3. Mytikas\n4. Musala"
        };
        String[] peopleAndPlacesQuestions = {
                "Who invented the light bulb?\n" + "1. Alexander Bell\n2. Thomas Edison\n3. Nikola Tesla\n4. Isaac Newton",
                "Of which religion is the Dalai Lama a leader?\n" + "1. Buddhism\n2. Judaism\n3. Islam\n4. Hinduism",
                "What is the world's most populated country?\n" + "1. India\n2. United States \n3. China\n4. Indonesia",
                "Indonesia was a colonized by which of the following empires?\n" + "1. Dutch\n2. American\n3. Chinese\n4. Indonesian",
                "Who was the first democratically elected President of South Africa?\n" + "1. Bob Marley\n2. Nelson Mandela\n3. Barak Obama\n4. Cyril Ramaphosa"


        };
        String[] languageQuestions = {
                "What does the Latin phrase \"Pro Bono\" mean?\n" + "1. Stipendiary\n2. Paid\n3. Free\n4. None of the above",
                "Which language is the most widely spoken throughout the world?\n" + "1. English \n2. Mandarin \n3. Spanish\n4. Bulgarian",
                "How does one say \"Hello\" in Spanish?\n" + "1. Hola\n2. Hallo\n3. Olá\n4. Bonjour",
                "What European language is spoken in Haiti?\n" + "1. Portuguese\n2. Spanish\n3. English\n4. French",
                "What does the Hindi greeting \"Namaste\" in English?\n" + "1. Welcome\n2. Hello\n3. Goodbye\n4. Thank you"
        };
        Question[] geoAnswers = {
                new Question(geographyQuestions[0], "1"),
                new Question(geographyQuestions[1], "3"),
                new Question(geographyQuestions[2], "2"),
                new Question(geographyQuestions[3], "1"),
                new Question(geographyQuestions[4], "4"),
        };
        Question[] peopleAndPlacesAnswers = {
                new Question(peopleAndPlacesQuestions[0], "2"),
                new Question(peopleAndPlacesQuestions[1], "1"),
                new Question(peopleAndPlacesQuestions[2], "3"),
                new Question(peopleAndPlacesQuestions[3], "4"),
                new Question(peopleAndPlacesQuestions[4], "2"),
        };
        Question[] languageAnswers = {
                new Question(languageQuestions[0], "3"),
                new Question(languageQuestions[1], "2"),
                new Question(languageQuestions[2], "1"),
                new Question(languageQuestions[3], "1"),
                new Question(languageQuestions[4], "2"),
        };

        takeTest(geoAnswers, peopleAndPlacesAnswers, languageAnswers);
    }

    public static void printCategory() {
        System.out.println("Lets play a quiz! Select category: ");
        System.out.println("1. Geography");
        System.out.println("2. People and places ");
        System.out.println("3. Language");
    }

    public static String chooseCategory(String categoryNum) {
        return switch (categoryNum) {
            case "1" -> "Geography";
            case "2" -> "People and places";
            case "3" -> "Language";
            default -> "Incorrect input";
        };
    }

    public static void printGeoQuestions(Question[] geoAnswers, int score) {
        Scanner userInput = new Scanner(System.in);
        for (int i = 0; i < geoAnswers.length; i++) {
            System.out.println(geoAnswers[i].ques);
            String userAnswer = userInput.nextLine();
            if (userAnswer.equals(geoAnswers[i].answer)) {
                score++;
            } else {
                System.out.println("Game over!");
                break;
            }
        }
        printScore(score);
    }

    public static void printPeopleAndPlacesQuestions(Question[] peopleAndPlacesAnswers, int score) {
        Scanner userInput = new Scanner(System.in);
        for (int i = 0; i < peopleAndPlacesAnswers.length; i++) {
            System.out.println(peopleAndPlacesAnswers[i].ques);
            String userAnswer = userInput.nextLine();
            if (userAnswer.equals(peopleAndPlacesAnswers[i].answer)) {
                score++;
            } else {
                System.out.println("Game over!");
                break;
            }
        }
        printScore(score);
    }

    public static void printLanguageQuestions(Question[] languageAnswers, int score) {
        Scanner userInput = new Scanner(System.in);
        for (int i = 0; i < languageAnswers.length; i++) {
            System.out.println(languageAnswers[i].ques);
            String userAnswer = userInput.nextLine();
            if (userAnswer.equals(languageAnswers[i].answer)) {
                score++;
            } else {
                System.out.println("Game over!");
                break;
            }
        }
        printScore(score);
    }

    public static void shuffleGeoArray(Question[] geoAnswers) {
        int index;
        Question temp;
        Random random = new Random();
        for (int i = geoAnswers.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = geoAnswers[index];
            geoAnswers[index] = geoAnswers[i];
            geoAnswers[i] = temp;
        }

    }

    public static void shufflePeopleAndPlacesArray(Question[] peopleAndPlacesAnswers) {
        int index;
        Question temp;
        Random random = new Random();
        for (int i = peopleAndPlacesAnswers.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = peopleAndPlacesAnswers[index];
            peopleAndPlacesAnswers[index] = peopleAndPlacesAnswers[i];
            peopleAndPlacesAnswers[i] = temp;
        }
    }

    public static void shuffleLanguageArray(Question[] languageAnswers) {
        int index;
        Question temp;
        Random random = new Random();
        for (int i = languageAnswers.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = languageAnswers[index];
            languageAnswers[index] = languageAnswers[i];
            languageAnswers[i] = temp;
        }

    }

    public static void printCategory(String categoryNum) {
        String result = ("Your category is: ".concat(chooseCategory(categoryNum)).concat("."));
        System.out.println(result);
    }

    public static void printScore(int score) {
        String points = ("You got " + score + "/5 points on your scoreboard! ");
        System.out.print(points);
    }

    public static void takeTest(Question[] geoAnswers, Question[] peopleAndPlacesAnswers, Question[] languageAnswers) {
        Scanner userInput = new Scanner(System.in);
        String categoryNum = userInput.nextLine();
        int score = 0;

    switch (categoryNum) {
        case "1" -> {
            shuffleGeoArray(geoAnswers);
            printGeoQuestions(geoAnswers, score);
        }
        case "2" -> {
            shufflePeopleAndPlacesArray(peopleAndPlacesAnswers);
            printPeopleAndPlacesQuestions(peopleAndPlacesAnswers, score);
        }
        case "3" -> {
            shuffleLanguageArray(languageAnswers);
            printLanguageQuestions(languageAnswers, score);

        }
    }
    printCategory(categoryNum);
}
    }




