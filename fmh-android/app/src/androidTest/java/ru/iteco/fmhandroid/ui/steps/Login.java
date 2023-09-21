package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.BeforeRunTest;
import ru.iteco.fmhandroid.R;

public class Login extends BasePage {
    private static final ViewInteraction loginField = onView(withId(R.id.login_text_input_layout));
    private static final ViewInteraction passwordField = onView(withId(R.id.password_text_input_layout));
    private static final ViewInteraction loginButton = onView(withText("Войти"));
    private static final ViewInteraction loginFieldAsTextField = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.login_text_input_layout))));
    private static final ViewInteraction passwordFieldAsTextField = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.password_text_input_layout))));
    private static final ViewInteraction titleTextElement = onView(withText("Авторизация"));


    @Step("Кнопка видна и кликабельна, текст соответстует")
    public static void titleTextElementCheck() {
        waitUntilElement(R.id.login_text_input_layout);
        existNotClickableText(titleTextElement, "Авторизация");
    }

    @Step("Тап по полю Логин")
    public static void loginFieldAsTextFieldClick() {
        loginFieldAsTextField.perform(click());
    }

    @Step("Тап по полю Пароль")
    public static void passwordFieldAsTextFieldClick() {
        passwordFieldAsTextField.perform(click());
    }

    @Step("Очистить поле Логин")
    public static void loginFieldAsTextFieldClear() {
        loginFieldAsTextField.perform(clearText());
        pauseSSt();
    }

    @Step("Очистить поле Пароль")
    public static void passwordFieldAsTextFieldClear() {
        passwordFieldAsTextField.perform(clearText());
        pauseSSt();
    }

    @Step("Тап по кнопке Авторизация")
    public static void loginButtonClick() {
        waitUntilElement("Войти");
        loginButton.perform(click());
    }

    @Step("Ввести текст в поле Логин")
    public static void loginFieldAsTextFieldType(String text) {
        waitUntilElement(R.id.login_text_input_layout);
        typeT(loginFieldAsTextField, text);
    }

    @Step("Ввести текст в поле Пароль")
    public static void passwordFieldAsTextFieldType(String text) {
        waitUntilElement(R.id.password_text_input_layout);
        typeT(passwordFieldAsTextField, text);
        passwordFieldAsTextField.perform(closeSoftKeyboard());
    }

    @Step("На странице Авторизации представлены необходимые элементы")
    public static void fieldsCheck() {
        waitUntilElement("Авторизация");
        Login.titleTextElement.check(matches(isDisplayed()));
        Login.titleTextElement.check(matches(withText("Авторизация")));

        Login.loginField.check(matches(isDisplayed()));
        Login.passwordField.check(matches(isDisplayed()));
        Login.loginButton.check(matches(isDisplayed()));

        Login.loginField.check(matches(hasTextInputLayout("Логин")));
        Login.passwordField.check(matches(hasTextInputLayout("Пароль")));
        Login.loginButton.check(matches((withText("Войти"))));
    }

    @Step("Проверка ошибки поля не могут быть пустые")
    public static void errorEmptyFieldsCheck() {
        onView(withText(R.string.empty_login_or_password)).inRoot(new ToastMatcher())
                .check(matches(withText("Логин и пароль не могут быть пустыми")));
    }

    @Step("Проверка ошибки поля не могут быть пустые")
    public static void errorWrongLoginOrPassword() {
        onView(withText(R.string.wrong_login_or_password)).inRoot(new BeforeRunTest.ToastMatcher())
                .check(matches(withText("Неверный логин или пароль")));
    }

}
