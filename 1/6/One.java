public class One{ 
      
    public static void main (String args[]){

        // byte
        byte b = 2;
        switch(b) {
            case 1: System.out.println("Number 1"); break;
            case 2: System.out.println("Number 2"); break;
        }

        // short
        short month = 12;
        switch(month) {
            case 12: System.out.println("December"); break;
        }

        // int
        int number = 5;
        switch(number) {
            case 5: System.out.println("Number Five"); break;
        }

        // char (также целочисленный)
        char estimate = 'A';
        switch(estimate) {
            case 'A': System.out.println("Excellent"); break;
            case 'B': System.out.println("Good"); break;
        }


        String color = "RED";
        switch(color) {
            case "RED": System.out.println("Stop"); break;
            case "GREEN": System.out.println("Go"); break;
            default: System.out.println("Wait"); break;
        }

        enum Season { RED, YELOW, GREEN }

        Season current = Season.RED;
        switch(current) {
            case RED: System.out.println("STOP"); break;
            case YELOW: System.out.println("WARNING"); break;
            case GREEN: System.out.println("GO"); break;
        }

    }
}