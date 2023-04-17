import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        String result = generatePojo("Car", "String", "model", "int", "speed");
        System.out.printf(result);
    }

    public static String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    private static String generatePojo(String ... params)
    {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < params.length; i+=2) {
            if (i == 0) {
                builder.append("public class " + params[i] + " {\n");
                continue;
            }
            builder.append("private " + params[i-1] + " " + params[i] + ";\n");
        }

        for (int i = 1; i < params.length; i+=2) {
            builder.append("public " + params[i] + " get" + firstUpperCase(params[i+1]) + "() {\n");
            builder.append("return " + params[i+1] + ";\n");
            builder.append("}\n");
            builder.append("public void set" + firstUpperCase(params[i+1]) + "(" + params[i] + " " + params[i+1] + ") {\n");
            builder.append("this." + params[i+1] + " = " + params[i+1] +";\n");
            builder.append("}\n");
        }

        builder.append("}\n");
        return builder.toString();
    }
}