package org.Test.Capability.Rewards;


import io.restassured.response.Response;
import org.Test.utils.ExcelUtils;
import org.Test.utils.RestUtils;
import org.Test.utils.TestCaseUtils;
import org.Test.utils.Testable;
import org.testng.annotations.Test;

import java.util.List;

public class RewardCertificates implements Testable {

    @Test
    public void intialSetupConfig() {
        List<String> urls = ExcelUtils.getSubCapabilityFromExcelAndGeneratesURLS("reward_certificates");
        String domain = RestUtils.UAT;
        TestCaseUtils.ExecuteTesting(urls, domain, this);
    }

    @Override
    public void Testing(Response response, String endpoint) {


        TestCaseUtils.textAtrributes(response,"rewards-tracker-dollars-to-go","{{nextRewardPoints}} in rewards to go!",TestCaseUtils.PLAIN_TEXT,endpoint);





         //-------18446-----------------
         TestCaseUtils.textAtrributes(response,"reward-tracker-current-reward-title","Your reward tracker",TestCaseUtils.PLAIN_TEXT,endpoint);
         TestCaseUtils.textAtrributes(response,"rewards-tracker-header","Track your progress",TestCaseUtils.PLAIN_TEXT,endpoint);



        TestCaseUtils.textAtrributes(response,"rewards-certificate-error-title","No available certificates",TestCaseUtils.PLAIN_TEXT,endpoint);

        TestCaseUtils.textAtrributes(response,"rewards-certificate-error-message","Here’s where you’ll find your certificates once they’re ready for you to use.",TestCaseUtils.PLAIN_TEXT,endpoint);

        TestCaseUtils.imageAttributesPath(response,"rewards-certificate-error-wave-bg","/assets/images/body/wave_background.png","_path",endpoint);





        TestCaseUtils.ctaAtrributes(response, "rewards-certificates-review-all", "Review all", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "reward-certificate-access-dialog-print-cta", "Print", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "reward-certificate-access-dialog-close-cta", "Close", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "rewards-tracker-keep-earning", "Keep earning", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "rewards-tracker-more-details", "More details", TestCaseUtils.PLAIN_TEXT, endpoint);

        TestCaseUtils.ctaAtrributes(response, "reward-certificate-access-dialog-close-cta", "Close the reward", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "reward-certificate-access-dialog-print-cta", "Print the reward", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "rewards-certificates-review-all", "Review all certificates", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "reward-certificate-access-dialog-print-cta", "Print the reward", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.ctaAtrributes(response, "reward-certificate-access-dialog-close-cta", "Close the reward", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);



        TestCaseUtils.imageAttributesPath(response, "icon-rewards-certificate-bg", "/assets/images/icon/icon_rewards_certificate_bg.png", "_path", endpoint);
        TestCaseUtils.imageAttributesPath(response, "icon-rewards-certificate-access-dialog-close-icon", "/assets/images/icon/icon_multi_brand_close.png", "_path", endpoint);
        TestCaseUtils.imageAttributesPath(response, "rewards-certificate-error-wave-bg", "/assets/images/body/wave_background.png", "_path", endpoint);

        // text


        //TestCaseUtils.textAtrributes(response, "rewards-access-certificates-current-rewards", "Available certificates", TestCaseUtils.PLAIN_TEXT, endpoint);

        //--- 18584
        TestCaseUtils.textAtrributes(response, "rewards-certificates-length-display", "Displaying {{filteredCertificates}} of {{certificates}} certificates", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "rewards-certificates-items-length-accessibility", "List of {{value}} items", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "certificate-history", "CERTIFICATE HISTORY", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "used-on-date-text", "Used on {{formattedDate}}", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "expired-on-date-text", "Expired on {{formattedDate}}", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "reward-certificate-amount", "${{rewardCertificateAmount}}", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "formatted-fulfil-date", "{{formattedFulfillDate}}", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "rewards-certificates-title", "Rewards Certificates", TestCaseUtils.PLAIN_TEXT, endpoint);

        TestCaseUtils.textAtrributes(response, "rewards-access-certificates-reward", "Reward", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "rewards-access-certificates-redeem-in-store", "Redeem in store or online", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "rewards-access-certificates-expires", "EXPIRES:", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "rewards-access-certificates", "Continue to access certificate details", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "rewards-access-certificates", "Access certificate", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "reward-certificate-access-dialog-title", "${{rewardAmt}} {{clientName}} Credit Card Reward", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "reward-certificate-access-dialog-bar-code-label", "Your credit card reward code", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "reward-certificate-access-dialog-reward-number-text", "Reward number", TestCaseUtils.PLAIN_TEXT, endpoint);

        TestCaseUtils.textAtrributes(response, "reward-certificate-access-dialog-pin-number-text", "PIN number", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "reward-certificate-access-dialog-terms-label", "Certificate Terms and Conditions", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "reward-certificate-print-title", "Reward Certificate", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "reward-certificate-print-amount", "{{rewardAmt}} Credit Card Reward", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "reward-certificate-print-earned-and-expire-date", "Earned {{fulfillDate}} | EXPIRES {{expireDate}}", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "reward-certificate-print-your-reward-code-text", "Your Reward Code:", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "biometric-trigger-dialog-close-icon", "Close the Reward", TestCaseUtils.PLAIN_TEXT, endpoint);

        TestCaseUtils.textAtrributes(response, "rewards-tracker-fulfill-accessibility", "You’ve earned {{earnedPoints}} points.", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "rewards-tracker-fulfill-accessibility", "null", TestCaseUtils.ACCESSIBILITY_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "rewards-certificate-error-message", "Here’s where you’ll find your certificates once they’re ready for you to use.", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "certificate-history-title", "Certificate History", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "certificate-history-heading", "CERTIFICATE HISTORY", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "certificate-history-description", "Every eligible purchase on your {{clientName}} {{cardName}} earns dollars.", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "rewards-certificate-load-more", "Load More", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "rewards-certificate-error-message-title", "Oops, we can’t display your certificate.", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "rewards-certificate-tracker-error-title", "We're Experiencing a Technical Issue", TestCaseUtils.PLAIN_TEXT, endpoint);


        TestCaseUtils.textAtrributes(response, "rewards-certificate-tracker-error-message", "Your number of purchase toward extra points can't be displayed. Our team is working to resolve this as soon as possible. Please try again later", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "reward-certificate-access-dialog-expires-text", "EXPIRES:", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "reward-certificate-access-dialog-print-terms-content", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nibh nisl condimentum id venenatis a condimentum vitae sapien pellentesque. Sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Mi bibendum neque egestas congue quisque egestas. Morbi leo urna molestie at elementum. Ornare arcu dui vivamus arcu felis bibendum ut tristique. Interdum velit laoreet id donec ultrices tincidunt arcu non sodales. Et pharetra pharet", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "reward-certificate-access-dialog-terms-content", "null", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "rewards-certificates-terms-conditions", "Rewards Terms and Conditions", TestCaseUtils.PLAIN_TEXT, endpoint);


       // TestCaseUtils.textAtrributes(response, "rewards-tracker-more-details-content", "null", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);

        //Might be changed
        TestCaseUtils.textAtrributes(response, "reward-certificate-access-dialog-description", "null", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response, "rewards-tracker-sub-copy", "null", TestCaseUtils.PLAIN_TEXT, endpoint);


        TestCaseUtils.textAtrributes(response,"rewards-tracker-brand-partner-site-url","null",TestCaseUtils.PLAIN_TEXT,endpoint);
        // Might be changed

        TestCaseUtils.textAtrributes(response, "rewards-certificate-error-title", "No available certificates", TestCaseUtils.PLAIN_TEXT, endpoint);
        TestCaseUtils.textAtrributes(response,"rewards-certificate-error-message","Here’s where you’ll find your certificates once they’re ready for you to use.",TestCaseUtils.PLAIN_TEXT,endpoint);



           /*
            TestCaseUtils.textAtrributes(response, "rewards-access-certificates-current-rewards", "Available certificates", TestCaseUtils.PLAIN_TEXT, endpoint);
            TestCaseUtils.textAtrributes(response, "rewards-tracker-certificates-amount-earned-text", "Amount earned:", TestCaseUtils.PLAIN_TEXT, endpoint);
            TestCaseUtils.textAtrributes(response, "rewards-tracker-certificates-earned-text", "Certificates earned:", TestCaseUtils.PLAIN_TEXT, endpoint);
            TestCaseUtils.textAtrributes(response, "rewards-tracker-dollars-to-go", "{{nextRewardPoints}} in rewards to go!", TestCaseUtils.PLAIN_TEXT, endpoint);
            TestCaseUtils.textAtrributes(response, "rewards-tracker-points-sub-copy", "Unlock a $10 certificate for every 200 points you earn.", TestCaseUtils.PLAIN_TEXT, endpoint);
            TestCaseUtils.textAtrributes(response, "rewards-tracker-dollar-sub-copy", "Unlock a $5 reward certificate for every $100 you earn.", TestCaseUtils.PLAIN_TEXT, endpoint);

            /*
            TestCaseUtils.textAtrributes(response, "reward-tracker-current-reward-title", "Your reward tracker", TestCaseUtils.PLAIN_TEXT, endpoint);
            TestCaseUtils.textAtrributes(response, "rewards-tracker-header", "Track your progress", TestCaseUtils.PLAIN_TEXT, endpoint);
            TestCaseUtils.textAtrributes(response, "rewards-tracker-points-to-go", "{{nextRewardPoints}} {{rewardType}} to go!", TestCaseUtils.PLAIN_TEXT, endpoint);
            TestCaseUtils.textAtrributes(response, "rewards-tracker-brand-partner-site-url", "null", TestCaseUtils.PLAIN_TEXT, endpoint);
        */


        TestCaseUtils.imageAttributesPath(response,"rewards-certificate-error-wave-bg","/assets/images/body/wave_background.png","_path",endpoint);
        TestCaseUtils.imageAttributesPath(response, "icon-rewards-cash", "/assets/images/icon/icon_rewards_cash.png", "_path", endpoint);
        TestCaseUtils.imageAttributesPath(response, "icon-rewards-certificate-bg", "/assets/images/icon/icon_rewards_certificate_bg.png", "_path", endpoint);
        TestCaseUtils.imageAttributesPath(response, "icon-rewards-certificate-access-dialog-close-icon", "/assets/images/icon/icon_multi_brand_close.png", "_path", endpoint);


        //-------18446-----------------
        TestCaseUtils.textAtrributes(response,"reward-tracker-current-reward-title","Your reward tracker",TestCaseUtils.PLAIN_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"rewards-tracker-header","Track your progress",TestCaseUtils.PLAIN_TEXT,endpoint);

        //------18447------------------
        TestCaseUtils.textAtrributes(response,"rewards-tracker-certificates-earned-text","Certificates earned:",TestCaseUtils.PLAIN_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"rewards-tracker-certificates-amount-earned-text","Amount earned:",TestCaseUtils.PLAIN_TEXT,endpoint);

        // -------18448---------------------------------------------------------
        TestCaseUtils.textAtrributes(response,"rewards-tracker-points-sub-copy","Unlock a $10 certificate for every 200 points you earn.",TestCaseUtils.PLAIN_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"rewards-tracker-dollar-sub-copy","Unlock a $5 reward certificate for every $100 you earn.",TestCaseUtils.PLAIN_TEXT,endpoint);
        TestCaseUtils.textAtrributes(response,"rewards-tracker-points-to-go","{{nextRewardPoints}} {{rewardType}} to go!",TestCaseUtils.PLAIN_TEXT,endpoint);

        //-------18455-----------------
        TestCaseUtils.textAtrributes(response,"rewards-access-certificates-current-rewards","Available certificates",TestCaseUtils.PLAIN_TEXT,endpoint);

        TestCaseUtils.textAtrributes(response, "rewards-certificate-error-message", "<p>We’re resolving a technical issue as quickly as possible. Please try again later.</p>", TestCaseUtils.HTTP_CONTENT_TYPE, endpoint);

       TestCaseUtils.imageAttributesPath(response, "icon-rewards-cash", "/assets/images/icon/icon_rewards_cash.png", "_path", endpoint);
       TestCaseUtils.imageAttributesPath(response, "icon-rewards-certificate-bg", "/assets/images/icon/icon_rewards_certificate_bg.png", "_path", endpoint);
       TestCaseUtils.imageAttributesPath(response, "icon-rewards-certificate-access-dialog-close-icon", "/assets/images/icon/icon_multi_brand_close.png", "_path", endpoint);
       TestCaseUtils.imageAttributesPath(response, "icon-rewards-cash", "/assets/images/rewards/rewards_tracker_brand_partner_site_url.png", "_path", endpoint);

    }
}

