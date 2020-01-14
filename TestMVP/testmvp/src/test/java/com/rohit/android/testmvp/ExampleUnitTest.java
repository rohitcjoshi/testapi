package com.rohit.android.testmvp;

import com.rohit.android.testmvp.presenter.ILoginPresenter;
import com.rohit.android.testmvp.presenter.LoginPresenterImpl;
import com.rohit.android.testmvp.view.ILoginView;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testCalculate() {
        LoginPresenterImpl presenter = new LoginPresenterImpl(new ILoginView() {
            @Override
            public void onLoginSuccess(String message) {

            }

            @Override
            public void onLoginError(String errorMessage) {

            }
        });
        assertTrue(presenter.calculateSomething() > 0);
    }
}