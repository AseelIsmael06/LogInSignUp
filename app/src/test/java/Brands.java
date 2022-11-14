public class Brands
{
    private String Benefit;
    private String  HudaBeauty;
    private String Sheglam;
    public void setBenefit(String benefit) {
        Benefit = benefit;
    }
    public void setHudaBeauty(String hudaBeauty) {
        HudaBeauty = hudaBeauty;
    }
    public void setSheglam(String sheglam) {
        Sheglam = sheglam;
    }
    public String getBenefit() {
        return Benefit;
    }

    public String getHudaBeauty() {
        return HudaBeauty;
    }

    public String getSheglam() {
        return Sheglam;
    }

    public Brands(String benefit, String hudaBeauty, String sheglam) {
        Benefit = benefit;
        HudaBeauty = hudaBeauty;
        Sheglam = sheglam;
    }
}
