import models.Brand;
import test.TestData;

public class App {

    public static void main(String[] args) {
        System.out.println("Examen interciclo de Estructuras de Datos");

        Brand[] brands = TestData.createBrands();

        System.out.println("Original:");
        for (int i = 0; i < brands.length; i++) {
            System.out.println(brands[i].getBrandName() + " - Años válidos: " + brands[i].getTotalValidYears());
        }

        brands = brands[0].sortBubbleDesc(brands);

        System.out.println("\nOrdenado por Bubble Sort descendente:");
        for (int i = 0; i < brands.length; i++) {
            System.out.println(brands[i].getBrandName() + " - Años válidos: " + brands[i].getTotalValidYears());
        }

        // Buscar marca con 7 años válidos
        System.out.print("\nBuscar marca con 7 años validos");
        int buscar1 = 7;
        Brand encontrado1 = brands[0].binarySearchByValidYears(brands, buscar1, false);
        if (encontrado1 != null) {
            System.out.println("\nMarca encontrada: " + encontrado1.getBrandName());
        } else {
            System.out.println("\nNo se encontró ninguna marca con " + buscar1 + " años válidos.");
        }

        // Buscar marca con 4 años válidos
        System.out.println("\nBuscar marca con 4 años validos");
        int buscar2 = 4;
        Brand encontrado2 = brands[0].binarySearchByValidYears(brands, buscar2, false);
        if (encontrado2 != null) {
            System.out.println("Marca encontrada: " + encontrado2.getBrandName());
        } else {
            System.out.println("No se encontró ninguna marca");
        }
    }
}
