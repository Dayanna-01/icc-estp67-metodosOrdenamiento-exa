package models;
public class Brand {

    private String BrandName;       
    private CarModel[] models; 

    public Brand(String name, CarModel[] models) {
        this.BrandName = name;
        this.models = models;
    }
    public String getBrandName() {
      return BrandName;
    }


    public void setBrandName(String brandname) {
      BrandName = brandname;
    }


    public CarModel[] getModels() {
      return models;
    }


    public void setModels(CarModel[] models) {
      this.models = models;
    }
    

    // 1. Calcular y retornar la cantidad total de años válidos de la marca
    public int getTotalValidYears() {
        int total = 0;

        if (models == null) return 0;

        for (CarModel model : models) {
            if (model == null) continue;
            CarYear[] years = model.getYears();
            if (years == null) continue;

            for (CarYear year : years) {
                if (year != null && year.isValid()) {
                    total++;
                }
            }
        }
        return total;
    }

    // 2. Ordenamiento Bubble Sort descendente por años válidos
    public Brand[] sortBubbleDesc(Brand[] brands) {
        if (brands == null) return null;

        for (int i = 0; i < brands.length - 1; i++) {
            for (int j = 0; j < brands.length - 1 - i; j++) {
                if (brands[j].getTotalValidYears() < brands[j + 1].getTotalValidYears()) {
                    Brand temp = brands[j];
                    brands[j] = brands[j + 1];
                    brands[j + 1] = temp;
                }
            }
        }
        return brands;
    }

    // 3. Búsqueda binaria por años válidos
    public Brand binarySearchByValidYears(Brand[] brands, int validYears, boolean isAscending) {
        if (brands == null) return null;

        int left = 0;
        int right = brands.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = brands[mid].getTotalValidYears();

            if (midValue == validYears) {
                return brands[mid];
            }

            if (isAscending) {
                if (validYears < midValue) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (validYears > midValue) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return null;
    }

}
