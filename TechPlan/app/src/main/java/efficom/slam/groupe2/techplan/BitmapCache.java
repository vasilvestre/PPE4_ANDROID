package efficom.slam.groupe2.techplan;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by lbettini on 27/02/17.
 */

public class BitmapCache extends LruCache <String,Bitmap> implements ImageLoader.ImageCache{
    /**
     * @param maxSize for caches that do not override {@link #sizeOf}, this is
     *                the maximum number of entries in the cache. For all other caches,
     *                this is the maximum sum of the sizes of the entries in this cache.
     */
    public BitmapCache(int maxSize) {
        super(maxSize);
    }

    public BitmapCache() {
        this(getDefaultCacheSize());
    }

    public static int getDefaultCacheSize(){
    final int maxMemory=(int)(Runtime.getRuntime().maxMemory()/1024);
    final int cacheSize=maxMemory/8;
        return cacheSize;
    }

    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes()*value.getHeight()/1024;
    }


    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }


    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        put(url,bitmap);

    }

    /**
     * Created by lbettini on 27/02/17.
     */

    public static class intervention {


        public String entreprise,id_intervention,intervention_duration,intervention_start,city,image;

        public String getEntreprise() {
            return entreprise;
        }

        public String getId_intervention() {
            return id_intervention;
        }

        public String getIntervention_duration() {
            return intervention_duration;
        }

        public String getIntervention_start() {
            return intervention_start;
        }

        public String getCity() {
            return city;
        }

        public String getImage() {
            return image;
        }
    }
}
