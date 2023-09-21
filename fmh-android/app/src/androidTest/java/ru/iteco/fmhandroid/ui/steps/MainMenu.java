package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;

public class MainMenu extends BasePage {

    private static final String mainPageTextRu = "Главная";
    private static final String claimPageTextRu = "Заявки";
    private static final String NewsPageTextRu = "Новости";
    private static final String aboutPageTextRu = "О приложении";
    private static final ViewInteraction mainPageButton = onView(withText("Главная")).inRoot(isPopupWindow());
    private static final ViewInteraction claimPageButton = onView(withText("Заявки")).inRoot(isPopupWindow());
    private static final ViewInteraction newsPageButton = onView(withText("Новости")).inRoot(isPopupWindow());
    private static final ViewInteraction aboutPageButton = onView(withText("О приложении")).inRoot(isPopupWindow());


    @Step("Кнопка видна и кликабельна, текст совпадает")
    public static void mainPageButtonCheck() {
        existText(mainPageButton, mainPageTextRu);
    }

    @Step("Кнопка видна и кликабельна, текст совпадает")
    public static void claimPageButtonCheck() {
        existText(claimPageButton, claimPageTextRu);
    }

    @Step("Кнопка видна и кликабельна, текст совпадает")
    public static void newsPageButtonCheck() {
        existText(newsPageButton, NewsPageTextRu);
    }

    @Step("Кнопка видна и кликабельна, текст совпадает")
    public static void aboutPageButtonCheck() {
        existText(aboutPageButton, aboutPageTextRu);
    }

    @Step("Кнопка видна и некликабельна, текст совпадает")
    public static void mainPageButtonNotClickCheck() {
        existNotClickableText(mainPageButton, mainPageTextRu);
    }

    @Step("Кнопка видна и некликабельна, текст совпадает")
    public static void claimPageButtonNotClickCheck() {
        existNotClickableText(claimPageButton, claimPageTextRu);
    }

    @Step("Кнопка видна и некликабельна, текст совпадает")
    public static void newsPageButtonNotClickCheck() {
        existNotClickableText(newsPageButton, NewsPageTextRu);
    }

    @Step("Тап по кнопке")
    public static void mainPageButtonClick() {
        mainPageButton.perform(click());
        pauseShort();
    }

    @Step("Тап по кнопке")
    public static void claimPageButtonClick() {
        claimPageButton.perform(click());
        pauseShort();
    }

    @Step("Тап по кнопке")
    public static void newsPageButtonClick() {
        newsPageButton.perform(click());
        pauseShort();
    }

    @Step("Тап по кнопке")
    public static void aboutPageButtonClick() {
        aboutPageButton.perform(click());
        pauseShort();
    }

    @Step("Проверка содержимого меню")
    public static void menuConsist() {
        mainPageButton.check(matches(isDisplayed()));
        mainPageButton.check(matches(withText(MainMenu.mainPageTextRu)));
        newsPageButton.check(matches(isDisplayed()));
        newsPageButton.check(matches(withText(MainMenu.NewsPageTextRu)));
        aboutPageButton.check(matches(isDisplayed()));
        aboutPageButton.check(matches(withText(MainMenu.aboutPageTextRu)));
        claimPageButton.check(matches(isDisplayed()));
        claimPageButton.check(matches(withText(MainMenu.claimPageTextRu)));
    }
}