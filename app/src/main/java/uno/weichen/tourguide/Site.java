package uno.weichen.tourguide;

/**
 * Created by weichen on 8/14/16.
 */
public class Site {
    /**
     * Name of the site
     */
    private String mName;
    /**
     * Address of the site
     */
    private String mAddress;
    /**
     * Image resource Id for the site
     */
    private int mResourceId;
    /**
     * Big Photo Id for the site
     */
    private int mPicId;
    /**
     * we might wanted to add TEL EMAIL BUSINESS_HOUR INTRODUCTION section in the future version
     */



    /**
     * default constructor
     */
    public Site(String mName, String mAddress, int mResourceId, int mPicId) {
        this.mName = mName;
        this.mAddress = mAddress;
        this.mResourceId = mResourceId;
        this.mPicId = mPicId;

    }

    public String getmName() {
        return mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public int getmResourceId() {
        return mResourceId;
    }

    public int getmPicId() {
        return mPicId;
    }

    /**
     * For debug
     * @return
     */
    @Override
    public String toString() {
        return "Site{" +
            "mName='" + mName + '\'' +
            ", mAddress='" + mAddress + '\'' +
            ", mResourceId=" + mResourceId +
            ", mPicId=" + mPicId +
            '}';
    }
}
