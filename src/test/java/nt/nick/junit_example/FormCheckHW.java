package nt.nick.junit_example;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.UploadFile;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormCheckHW {

    public static String[][] asserts = new String[10][2];



    @BeforeAll
    static void preConditions(){
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1280x960";
    }

    @Test
    void checkPractiseForm(){

        open("automation-practice-form");
        jsDisplayNone("Footer");

        $("#firstName").setValue("Nick");
        $("#lastName").setValue("Kudryavtsev");
        $("#userEmail").setValue("nick@ya.ru");
        $(".custom-control.custom-radio.custom-control-inline:nth-child(1)").click();
        $("#userNumber").setValue("8800555353");
        jsSetDataPicker("#dateOfBirthInput", "13 Sep 2022");
        $("#subjectsInput").setValue("Math").pressEnter();
        $(".custom-control.custom-checkbox.custom-control-inline:nth-child(1)").click();
        $("#uploadPicture").uploadFromClasspath("lesson.png");
        $("#currentAddress").setValue("Something");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $(".table-responsive table").shouldHave(
                text("Nick"),
                text("Kudryavtsev"),
                text("nick@ya.ru"),
                text("8800555353")
        );


    }

    void jsDisplayNone(String el){
        executeJavaScript(
                String.format("document.querySelector(\"%s\").style.display = \"none\"", el)
        );
    }

    void jsSetDataPicker(String el, String date){
        executeJavaScript(
                String.format("document.querySelector(\"%s\").value = \"%s\"", el, date)
        );
    }


}
