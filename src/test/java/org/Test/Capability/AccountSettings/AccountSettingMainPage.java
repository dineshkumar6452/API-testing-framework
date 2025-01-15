package org.Test.Capability.AccountSettings;


import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class AccountSettingMainPage implements Testable {


    @Test
    public void intialSetupConfig() {
       List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("account_setting_main_page");
        String domain = RestUtils.PROD;
       // String domain = RestUtils.DEV;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }

    @Override
    public void Testing(Response response, String endpoint) {
        TestCaseUtils.textAtrributes(response, "account-setting-username", "Username", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-face-id", "Face ID", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-touch-id", "Touch ID", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-biometric-1", "Biometric Authentication", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-biometric-2", "Biometric Authentication", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-alert-dialog", "Alert", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-mobile-wallet", "Manage your digital wallet", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "home-page-logout-cta", "Log out", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-time-ago-minute-ago", "Last login: {{minute}} minute ago", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-settings-headers", "Account settings", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "help-feedback-headers", "Help & feedback", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-greeting-text", "Welcome, {{firstName}}", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_current_Year_Last_Login_Time", "Last login: {{currentYearLastLoginDate}} at {{currentYearLastLoginTime}}", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_past_Years_Last_Login_Time", "Last login: {{pastYearLastLoginDate}} at {{pastYearLastLoginTime}}", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_yesterday_at", "Last login: Yesterday at {{time}}", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_today_at", "Last login: Today at {{time}}", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_ago_hours_minutes_ago", "Last login: {{hours}} hours {{minutes}} minutes ago", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_ago_hours_minute_ago", "Last login: {{hours}} hours {{minute}} minute ago", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_ago_hour_minutes_ago", "Last login: {{hour}} hour {{minutes}} minutes ago", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_ago_hour_minute_ago", "Last login: {{hour}} hour {{minute}} minute ago", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_ago_hour_ago", "Last login: {{hour}} hour ago", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_ago_minutes_ago", "Last login: {{minutes}} minutes ago", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "wrong-password-message-while-logout", "Sorry, that’s too many incorrect password attempts.", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-time-ago-about-a-minute-ago", "Last login: about a minute ago", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "logout-dialog-title", "We're logging you out", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "logout-dialogue-description", "You will have to log back in to the app to access your account.", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-biometric-type-text", "We use {{biometricType}} to login to the application.", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-settings-credit-limit-increase", "Credit limit increase", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-edit-profile", "Edit your Profile", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "help-faq-as-expand-all-text", "Expand All", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "help-faq-as-collapse-all-text", "Collapse All", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "privacy-preferences-title", "Privacy preferences", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-username", "Continue to update your username", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-face-id", "Continue to set up Face ID", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-touch-id", "Continue to Touch ID page", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-biometric-2", "Biometric Authentication", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "home-page-logout-cta", "Continue to log out ", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "help-feedback-headers", "Continue to help & feedback page", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-settings-credit-limit-increase", "Credit Limit Increase", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-edit-profile", "Edit your profile", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "privacy-preferences-title", "Privacy preferences", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "help-faq-topics-list-count", "List of {{value}} items", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-username", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-face-id", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-touch-id", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-biometric-1", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-biometric-2", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-alert-dialog", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-mobile-wallet", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "home-page-logout-cta", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-time-ago-minute-ago", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account-settings-headers", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "help-feedback-headers", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-greeting-text", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_current_Year_Last_Login_Time", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_past_Years_Last_Login_Time", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_yesterday_at", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_today_at", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_ago_hours_minutes_ago", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_ago_hours_minute_ago", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_ago_hour_minutes_ago", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_ago_hour_minute_ago", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_ago_hour_ago", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account_setting_time_ago_minutes_ago", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "wrong-password-message-while-logout", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-time-ago-about-a-minute-ago", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "logout-dialog-title", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "logout-dialogue-description", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-biometric-type-text", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account-settings-credit-limit-increase", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-edit-profile", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "help-faq-as-expand-all-text", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "help-faq-as-collapse-all-text", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "privacy-preferences-title", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);
        TestCaseUtils.textAtrributes(response, "help-faq-topics-list-count", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);

        //---18073
        TestCaseUtils.textAtrributes(response, "account-setting-edit-profile", "Edit your profile", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-help", "FAQs", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-feedback", "Give feedback", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-logout", "Sign out", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-authbuyers-cta", "Authorized buyers", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-payment-info-text", "Payment info", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-mobile-wallet-header", "Digital wallet", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-help", "FAQs", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-feedback", "Give feedback", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-policy-and-terms", "Privacy Policies & Terms", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-logout", "Sign out", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-lock-unlock-card", "Lock & unlock card", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-lock-card", "Lock cards", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-unlock-card", "Unlock card", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-activate-card", "Activate card", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-help-text", "Help", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-cards-unlock", "Unlock cards", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-edit-username-password-cta", "Username & password", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-smc-cta", "Secure Message Center", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-smc-communication", "Communications", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-authbuyers-cta", "Select to add Authorized buyers", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-payment-info-text", "Payment info", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-help", "FAQs", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-feedback", "Give feedback", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-policy-and-terms", "Review policies and terms", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-logout", "Sign out", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-activate-card", "Continue to activate your card", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "appbar-back-arrow-icon-cta-text", "Review app navigation", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-help-text", "Continue to Help page", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-edit-username-password-cta", "Continue to edit your username and password", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-smc-cta", "Secure message center", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-lock-unlock-cta", "Continue to review lock card settings", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "account-setting-edit-profile", "Edit your profile", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-help", "FAQs", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-feedback", "Give feedback", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "account-setting-logout", "Sign out", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
    }
}
