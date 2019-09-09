package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText numberInput;
	private Button guessButton;
	private int randomNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		numberInput = findViewById(R.id.number_input);
		guessButton = findViewById(R.id.guess_button);
		initRandomNumber();
	}
	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(this, "App on Start", Toast.LENGTH_SHORT).show();
	}
	@Override
	protected void onStop() {
		super.onStop();
		Toast.makeText(this, "App on Stop", Toast.LENGTH_SHORT).show();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random random = new Random();
		int min = 1;
		int max = 100;
		randomNumber = random.nextInt(max - min) + min;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		int input = Integer.parseInt(numberInput.getText().toString());
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

		if(input == randomNumber){
			alertDialogBuilder.setMessage("Tebakan Anda Benar!!");
			guessButton.setEnabled(false);
		}
		else if (input > randomNumber){
				alertDialogBuilder.setMessage("Tebakan Anda Terlalu Besar!");
		}
		else if (input < randomNumber) {
			alertDialogBuilder.setMessage("Tebakan Anda Terlalu Kecil!");
		}

		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		numberInput.setText("");
		guessButton.setEnabled(true);
		initRandomNumber();
	}
}
