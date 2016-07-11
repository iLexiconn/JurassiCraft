package net.ilexiconn.jurassicraft.client.model.base;

public class ControlledParam {
    public float value;
    public float change;
    public float max;
    public float min;
    public int pause;
    public int mode;

    public ControlledParam(float value, float change, float max, float min) {
        this.value = value;
        this.change = change;
        this.max = max;
        this.min = min;
    }

    public void thereAndBack(float start, float change, float destination, int pause) {
        mode = 1;
        this.value = start;
        this.change = change;
        this.max = destination;
        this.min = start;
        this.pause = pause;
    }

    public void update() {
        if (mode == 1) {
            if (value == max && pause != 0)
                pause -= 1;
            if (pause != 0)
                value += change;
            if (pause == 0)
                value -= change;
        } else {
            value += change;
        }

        if (value < min)
            value = min;
        if (value > max)
            value = max;
    }
}