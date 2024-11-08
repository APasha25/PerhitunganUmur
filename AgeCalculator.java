import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Program Penghitung Umur untuk menghitung umur berdasarkan tanggal lahir yang diberikan oleh pengguna.
 */
public class AgeCalculator {

    /**
     * Menghitung umur berdasarkan tanggal lahir yang diberikan.
     *
     * @param birthDate Tanggal lahir dalam format LocalDate.
     * @return Umur dalam tahun.
     * @throws IllegalArgumentException jika tanggal lahir berada di masa depan.
     */
    public int calculateAge(LocalDate birthDate) {
        if (birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Tanggal lahir tidak boleh berada di masa depan.");
        }
        Period age = Period.between(birthDate, LocalDate.now());
        return age.getYears();
    }

    /**
     * Metode utama yang menjalankan aplikasi Penghitung Umur.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam program ini).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgeCalculator ageCalculator = new AgeCalculator();

        System.out.print("Masukkan tanggal lahir Anda (format YYYY-MM-DD): ");
        String input = scanner.nextLine();

        try {
            LocalDate birthDate = LocalDate.parse(input);
            int age = ageCalculator.calculateAge(birthDate);
            System.out.println("Umur Anda adalah: " + age + " tahun.");
        } catch (DateTimeParseException e) {
            System.out.println("Format tanggal tidak valid. Harap gunakan format YYYY-MM-DD.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
