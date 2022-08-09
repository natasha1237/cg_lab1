public class DirectedLightSource {
    Vector light;

    DirectedLightSource() {
        light = new Vector(new Point(-1, -1, -1));
        light = new Vector(light.getVectorized().div(light.length()));
    }
    DirectedLightSource(Vector light) {
        this.light = new Vector(light.getVectorized().div(light.length()));
    }
    DirectedLightSource(DirectedLightSource dls) {
        this.light = new Vector(dls.light);
    }

    public Vector getLight() {
        return light;
    }
}
