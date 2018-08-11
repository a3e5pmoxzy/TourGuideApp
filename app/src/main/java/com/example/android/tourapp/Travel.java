package com.example.android.tourapp;

public class Travel {

    private String mSecOneCatOnePos1;
    private String mSecOneCatOnePos2;
    private String mSecOneCatOnePos3;
    private String mSecOneCatOnePos4;
    private String mSecOneCatOnePos5;
    private String mSecOneCatOnePos6;
    private int mAudioResourceId;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new secOneCatOneObj object.
     *
     * @param secOneCatOnePos1 is the secOneCatOneObj for the position 1
     * @param secOneCatOnePos2 is the secOneCatOneObj for the position 2
     * @param secOneCatOnePos3 is the secOneCatOneObj for the position 3
     * @param secOneCatOnePos4 is the secOneCatOneObj for the position 4
     * @param secOneCatOnePos5 is the secOneCatOneObj for the position 5
     * @param secOneCatOnePos6 is the secOneCatOneObj for the position 6
     *
     * @param audioResourceId is the ID for audio secOneCatOneObj
     */
    public Travel(String secOneCatOnePos1, String secOneCatOnePos2, String secOneCatOnePos3, String secOneCatOnePos4, String secOneCatOnePos5, String secOneCatOnePos6, int audioResourceId) {
        mSecOneCatOnePos1 = secOneCatOnePos1;
        mSecOneCatOnePos2 = secOneCatOnePos2;
        mSecOneCatOnePos3 = secOneCatOnePos3;
        mSecOneCatOnePos4 = secOneCatOnePos4;
        mSecOneCatOnePos5 = secOneCatOnePos5;
        mSecOneCatOnePos6 = secOneCatOnePos6;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Create a new secOneCatOneObj object.
     *
     * @param secOneCatOnePos1 is the secOneCatOneObj for the position 1
     * @param secOneCatOnePos2 is the secOneCatOneObj for the position 2
     * @param secOneCatOnePos3 is the secOneCatOneObj for the position 3
     * @param secOneCatOnePos4 is the secOneCatOneObj for the position 4
     * @param secOneCatOnePos5 is the secOneCatOneObj for the position 5
     * @param secOneCatOnePos6 is the secOneCatOneObj for the position 6
     * @param imageResourceId is the drawable resource ID for the image associated with the secOneCatOneObj
     * @param audioResourceId is the resource ID for the audio file associated with this secOneCatOneObj
     */
    public Travel(String secOneCatOnePos1, String secOneCatOnePos2, String secOneCatOnePos3, String secOneCatOnePos4, String secOneCatOnePos5, String secOneCatOnePos6, int imageResourceId, int audioResourceId) {
        mSecOneCatOnePos1 = secOneCatOnePos1;
        mSecOneCatOnePos2 = secOneCatOnePos2;
        mSecOneCatOnePos3 = secOneCatOnePos3;
        mSecOneCatOnePos4 = secOneCatOnePos4;
        mSecOneCatOnePos5 = secOneCatOnePos5;
        mSecOneCatOnePos6 = secOneCatOnePos6;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getSecOneCatOnePos1() {
        return mSecOneCatOnePos1;
    }
    public String getSecOneCatOnePos2() {
        return mSecOneCatOnePos2;
    }
    public String getSecOneCatOnePos3() {
        return mSecOneCatOnePos3;
    }
    public String getSecOneCatOnePos4() {
        return mSecOneCatOnePos4;
    }
    public String getSecOneCatOnePos5() {
        return mSecOneCatOnePos5;
    }
    public String getSecOneCatOnePos6() {
        return mSecOneCatOnePos6;
    }

    /**
     * Return the image resource ID of the secOneCatOneObj.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this secOneCatOneObj.
     * @return
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return the audio resource ID of the secOneCatOneObj.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

}