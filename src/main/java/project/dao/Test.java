package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import project.connectionUtil.*;
import project.models.*;
import project.service.userService;

public class Test {

	public static void main(String[] args) {

		userService us = new userService();

		us.register();

	}

}
