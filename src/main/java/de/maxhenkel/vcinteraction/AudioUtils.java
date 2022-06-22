package de.maxhenkel.vcinteraction;

public class AudioUtils {

    /**
     * Calculates the audio level of a signal with specific samples.
     *
     * @param samples the samples of the signal to calculate the audio level of
     * @return the audio level of the specified signal in db
     */
    public static double calculateAudioLevel(short[] samples) {
        double rms = 0D; // root mean square (RMS) amplitude

        for (int i = 0; i < samples.length; i++) {
            double sample = (double) samples[i] / (double) Short.MAX_VALUE;
            rms += sample * sample;
        }

        int sampleCount = samples.length / 2;

        rms = (sampleCount == 0) ? 0 : Math.sqrt(rms / sampleCount);

        double db;

        if (rms > 0D) {
            db = Math.min(Math.max(20D * Math.log10(rms), -127D), 0D);
        } else {
            db = -127D;
        }

        return db;
    }

}
