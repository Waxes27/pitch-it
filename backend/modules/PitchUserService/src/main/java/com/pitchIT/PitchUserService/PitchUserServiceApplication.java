package com.pitchIT.PitchUserService;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Objects;

@SpringBootApplication
public class PitchUserServiceApplication {

	public static void main(String[] args) throws IOException {

		ClassLoader classLoader = PitchUserServiceApplication.class.getClassLoader();
		InputStream serviceAccount = classLoader.getResourceAsStream("serviceAccountKey.json");


//		FileInputStream serviceAccount =
//				new FileInputStream(file.);

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://chat-4c31c-default-rtdb.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);
//		System.out.println("Init done");

//		SpringApplication.run(PitchUserServiceApplication.class, args);
	}

}
