package android.support.v4.view.animation;

public class FastOutSlowInInterpolator
  extends LookupTableInterpolator
{
  private static final float[] VALUES = { 0.0F, 1.0E-4F, 2.0E-4F, 5.0E-4F, 9.0E-4F, 0.0014F, 0.002F, 0.0027F, 0.0036F, 0.0046F, 0.0058F, 0.0071F, 0.0085F, 0.0101F, 0.0118F, 0.0137F, 0.0158F, 0.018F, 0.0205F, 0.0231F, 0.0259F, 0.0289F, 0.0321F, 0.0355F, 0.0391F, 0.043F, 0.0471F, 0.0514F, 0.056F, 0.0608F, 0.066F, 0.0714F, 0.0771F, 0.083F, 0.0893F, 0.0959F, 0.1029F, 0.1101F, 0.1177F, 0.1257F, 0.1339F, 0.1426F, 0.1516F, 0.161F, 0.1707F, 0.1808F, 0.1913F, 0.2021F, 0.2133F, 0.2248F, 0.2366F, 0.2487F, 0.2611F, 0.2738F, 0.2867F, 0.2998F, 0.3131F, 0.3265F, 0.34F, 0.3536F, 0.3673F, 0.381F, 0.3946F, 0.4082F, 0.4217F, 0.4352F, 0.4485F, 0.4616F, 0.4746F, 0.4874F, 0.5F, 0.5124F, 0.5246F, 0.5365F, 0.5482F, 0.5597F, 0.571F, 0.582F, 0.5928F, 0.6033F, 0.6136F, 0.6237F, 0.6335F, 0.6431F, 0.6525F, 0.6616F, 0.6706F, 0.6793F, 0.6878F, 0.6961F, 0.7043F, 0.7122F, 0.7199F, 0.7275F, 0.7349F, 0.7421F, 0.7491F, 0.7559F, 0.7626F, 0.7692F, 0.7756F, 0.7818F, 0.7879F, 0.7938F, 0.7996F, 0.8053F, 0.8108F, 0.8162F, 0.8215F, 0.8266F, 0.8317F, 0.8366F, 0.8414F, 0.8461F, 0.8507F, 0.8551F, 0.8595F, 0.8638F, 0.8679F, 0.872F, 0.876F, 0.8798F, 0.8836F, 0.8873F, 0.8909F, 0.8945F, 0.8979F, 0.9013F, 0.9046F, 0.9078F, 0.9109F, 0.9139F, 0.9169F, 0.9198F, 0.9227F, 0.9254F, 0.9281F, 0.9307F, 0.9333F, 0.9358F, 0.9382F, 0.9406F, 0.9429F, 0.9452F, 0.9474F, 0.9495F, 0.9516F, 0.9536F, 0.9556F, 0.9575F, 0.9594F, 0.9612F, 0.9629F, 0.9646F, 0.9663F, 0.9679F, 0.9695F, 0.971F, 0.9725F, 0.9739F, 0.9753F, 0.9766F, 0.9779F, 0.9791F, 0.9803F, 0.9815F, 0.9826F, 0.9837F, 0.9848F, 0.9858F, 0.9867F, 0.9877F, 0.9885F, 0.9894F, 0.9902F, 0.991F, 0.9917F, 0.9924F, 0.9931F, 0.9937F, 0.9944F, 0.9949F, 0.9955F, 0.996F, 0.9964F, 0.9969F, 0.9973F, 0.9977F, 0.998F, 0.9984F, 0.9986F, 0.9989F, 0.9991F, 0.9993F, 0.9995F, 0.9997F, 0.9998F, 0.9999F, 0.9999F, 1.0F, 1.0F };
  
  public FastOutSlowInInterpolator()
  {
    super(VALUES);
  }
}


/* Location:              C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\android\support\v4\view\animation\FastOutSlowInInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */