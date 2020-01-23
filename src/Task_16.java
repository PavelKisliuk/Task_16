import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task_16 {
	public static void main(String[] args) {
		String outputPath = "OUTPUT.TXT";
		String inputPath = "INPUT.TXT";
		Ladder test = new Ladder(inputPath);
		try (BufferedWriter output = Files.newBufferedWriter(Paths.get(outputPath))) {
			output.write(test.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Ladder {
	private int cubeAmount;
	private int stepAmount;

	public Ladder(String path) {
		try (final BufferedReader input = Files.newBufferedReader(Paths.get(path))) {
			String data = input.readLine();
			cubeAmount = Integer.parseInt(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		count();
	}

	private void count() {
		if (cubeAmount < 3) {
			stepAmount = 1;
			return;
		}
		recurseCount(1, cubeAmount);
	}

	private void recurseCount(int point, int cubeAmount) {
		for (int i = point; i <= cubeAmount; i++) {
			recurseCount(i + 1, cubeAmount - i);
		}
		if (cubeAmount == 0) {
			stepAmount++;
		}
	}

	@Override
	public String toString() {
		return String.valueOf(stepAmount);
	}
}