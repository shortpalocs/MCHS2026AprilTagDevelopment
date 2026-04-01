import edu.wpi.first.wpilibj.Servo;
public class ServoSS {


    private final Servo servo = new Servo(0);

    public void setAngle(double angle) {
        servo.setAngle(angle);
    }



   
}