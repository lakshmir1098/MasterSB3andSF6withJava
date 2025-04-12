package com.learnings.SpringIntro.Configuration;

public record Person(String name, int age, Address add) {
        //When you want to make record class public explicitly then you have to create a seperate class.
        // We are making this public because Configuration java class  is different package than SpringInro java class
        }
