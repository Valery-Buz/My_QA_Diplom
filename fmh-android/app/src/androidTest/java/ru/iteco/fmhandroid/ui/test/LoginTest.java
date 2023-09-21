package ru.iteco.fmhandroid.ui.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.steps.Login;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.BasePage;
import ru.iteco.fmhandroid.ui.steps.HeaderPage;
import ru.iteco.fmhandroid.ui.steps.LkMenu;
import ru.iteco.fmhandroid.ui.steps.SplashScreenPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AllureAndroidJUnit4.class)
public class LoginTest extends BasePage {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    public void login() {
        Login.loginFieldAsTextFieldType("login2");
        Login.passwordFieldAsTextFieldType("password2");
        Login.loginButtonClick();
    }

    public void logout() {
        HeaderPage.lkButtonClick();
        LkMenu.logoutButtonClick();
    }

    @Description("На странице Авторизации представлены необходимые элементы")
    @Story("Проверка Стартовой Страницы")
    @Test
    public void A_ShouldBeVisibleAllElementsLogin() {
        Login.fieldsCheck();
    }

    @Description("На странице Авторизации представлены необходимые элементы")
    @Story("Проверка страницы Авторизации")
    @Test
    public void B_ShouldShowElementsAuthPage() {
        Login.loginButtonClick();
        Login.loginFieldAsTextFieldClick();
        assertTrue(isKeyboardOpenedShellCheck());
        Login.passwordFieldAsTextFieldClick();
        assertTrue(isKeyboardOpenedShellCheck());
        clickBack();
        waitUntilKeyboardHide();
        assertFalse(isKeyboardOpenedShellCheck());
    }

    @Description("При пустом поле появляется сообщение об ошибке")
    @Story("Проверка страницы Авторизации")
    @Test
    public void C_shouldShowErrorWithOneEmptyField() {
        Login.loginFieldAsTextFieldType("login");
        Login.loginButtonClick();
        Login.errorEmptyFieldsCheck();

        Login.loginFieldAsTextFieldClear();
        Login.passwordFieldAsTextFieldType("password");
        Login.loginButtonClick();
        Login.errorEmptyFieldsCheck();
        Login.passwordFieldAsTextFieldClear();
    }

    @Description("При вводе произвольных логин пароль не входит в приложение")
    @Story("Проверка страницы Авторизации")
    @Test
    public void D_shouldShowErrorWithWrongValues() {
        Login.loginFieldAsTextFieldType("login");
        Login.passwordFieldAsTextFieldType("password");
        Login.loginButtonClick();
        Login.errorWrongLoginOrPassword();
    }

    @Description("При вводе валидных логин пароль входит в приложение")
    @Story("Проверка страницы Авторизации")
    @Test
    public void E_ShouldLogin() {
        Login.titleTextElementCheck();
        Login.loginFieldAsTextFieldType("login2");
        Login.passwordFieldAsTextFieldType("password2");
        waitUntilKeyboardHide();
        Login.loginButtonClick();
    }

    @Description("После авторизации пользователя при перезапуске отображается страница загрузки")
    @Story("Проверка Главной страницы")
    @Test
    public void F_ShouldAppStartOnSplashScreenPageWhenUserLogin() {
        SplashScreenPage.screenSplashCheK();
    }

    @Description("После авторизации пользователя при перезапуске открывается Главная страница")
    @Story("Проверка Главной страницы")
    @Test
    public void G_ShouldAppStartOnMainPageWhenUserLogin() {

        HeaderPage.logoCheck();
        logout();
    }

    @Description("После выхода пользователя при перезапуске открывается страница Авторизации")
    @Story("Проверка Главной страницы")
    @Test
    public void H_ShouldAppStartOnAuthPageWhenUserLogOut() {
        Login.titleTextElementCheck();
        login();
    }

    @Description("запуск авторизованным пользователем при перезапуске приложения авторизванным пользователем")
    @Story("Проверка Главной страницы")
    @Test
    public void I_ShouldStartAppOnMainPageWhenAuthorized() {
        HeaderPage.mainMenuButtonCheck();
        logout();
    }

}
