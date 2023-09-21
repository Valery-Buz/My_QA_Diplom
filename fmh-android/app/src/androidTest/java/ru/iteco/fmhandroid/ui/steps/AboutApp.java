package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class AboutApp extends BasePage {
    private static final String aboutAppText = "Версия:";
    private static final String aboutAppVersion = "1.0.0";
    private static final String policyText = "Политика конфиденциальности:";
    private static final String policyLink = "https://vhospice.org/#/privacy-policy";
    private static final String userAgreementText = "Пользовательское соглашение:";
    private static final String userAgreementLink = "https://vhospice.org/#/terms-of-use";
    private static final String companyInfo = "© Айтеко, 2022";
    private static final ViewInteraction backButton = onView(withId(R.id.about_back_image_button));
    private static final ViewInteraction logoView = onView(withId(R.id.trademark_image_view));
    private static final ViewInteraction versionTitleId = onView(withId(R.id.about_version_title_text_view));
    private static final ViewInteraction versionTextId = onView(withId(R.id.about_version_value_text_view));
    private static final ViewInteraction policyTextId = onView(withId(R.id.about_privacy_policy_label_text_view));
    private static final ViewInteraction policyLinkId = onView(withId(R.id.about_privacy_policy_value_text_view));
    private static final ViewInteraction userAgreementTextId = onView(withId(R.id.about_terms_of_use_label_text_view));
    private static final ViewInteraction userAgreementLinkId = onView(withId(R.id.about_terms_of_use_value_text_view));
    private static final ViewInteraction companyId = onView(withId(R.id.about_company_info_label_text_view));

    @Step("Кнопка Назад видна и кликабельна")
    public static void backButtonCheck(){
        existClickable(backButton);
    }
    @Step("Клик по кнопке")
    public static void backButtonClick(){
        backButton.perform(click());
    }
    @Step("Логотип присутствует")
    public static void logoCheck(){
        existNotClickable(logoView);
    }
    @Step("Версия приложения заголовок присутствует")
    public static void versionTitleIdCheck(){
        waitUntilElement(R.id.about_version_title_text_view);
        existText(versionTitleId, aboutAppText);
    }
    @Step("Присутствует текст версии")
    public static void versionTextIdCheck(){
        existText(versionTextId, aboutAppVersion);
    }
    @Step("Присутствует ссылка Политика конфиденциальности")
    public static void policyLinkIdCheck(){
        existText(policyLinkId, policyLink);
    }
    @Step("Присутствует текст ссылки Политика конфиденциальности")
    public static void policyTextIdCheck(){
        existText(policyTextId, policyText);
    }
    @Step("Присутствует текст ссылки Пользовательское соглашение")
    public static void userAgreementTextIdCheck(){
        existText(userAgreementTextId, userAgreementText);
    }
    @Step("Присутствует ссылка Пользовательское соглашение")
    public static void userAgreementLinkIdCheck(){
        existText(userAgreementLinkId, userAgreementLink);
    }
    @Step("Присутствует текст О компании")
    public static void companyIdCheck(){
        existText(companyId, companyInfo);
    }
}
