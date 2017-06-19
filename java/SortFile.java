 public TreeMap<String, String> SortFile(String path) throws Exception {
        String fileName = path;
        File file = new File(fileName);
        TreeMap<String, String> content_string = new TreeMap<>();
        try {
            // Объект для чтения файла в буффер
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                // В цикле построчно считываем файл
                String raw;
                while ((raw = in.readLine()) != null) {
                    // Сортируем данные из файла, так как они записываются в случайном порядке
                    String element = raw.split(",")[0];
                    content_string.put(element, raw);
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw e;
        }
        // Возвращаем полученный отсортированный текст из файла
        return content_string;
    }
