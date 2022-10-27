package com.railway.reservation;

public class RailwayApp {
public static void main(String args[]) {
	RailwayApp railway = new RailwayApp();
	railway.start();
}

private void start() {
	MainView main = new MainView();
	main.initiate();
}
}
