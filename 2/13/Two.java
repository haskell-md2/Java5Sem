public class Two {
    public static void main(String[] args) {
        for (Color c : Color.values()) {
            System.out.println(c + ": " + c.signalMessage());
        }
    }
}

enum Color {
    RED(30),
    YELLOW(5),
    GREEN(25);

    private final int duration; // время в секундах, сколько горит свет

    private Color(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    // Дополнительный метод, который возвращает сообщение о текущем сигнале
    public String signalMessage() {
        switch (this) {
            case RED:
                return "Стоп! Ждите " + duration + " секунд.";
            case YELLOW:
                return "Будьте готовы. Свет горит " + duration + " секунд.";
            case GREEN:
                return "Идите! Свет горит " + duration + " секунд.";
            default:
                return "Неизвестный сигнал.";
        }
    }
}