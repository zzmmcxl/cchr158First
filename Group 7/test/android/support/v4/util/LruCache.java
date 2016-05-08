package android.support.v4.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> {
   private int createCount;
   private int evictionCount;
   private int hitCount;
   private final LinkedHashMap<K, V> map;
   private int maxSize;
   private int missCount;
   private int putCount;
   private int size;

   public LruCache(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("maxSize <= 0");
      } else {
         this.maxSize = var1;
         this.map = new LinkedHashMap(0, 0.75F, true);
      }
   }

   private int safeSizeOf(K var1, V var2) {
      int var3 = this.sizeOf(var1, var2);
      if(var3 < 0) {
         throw new IllegalStateException("Negative size: " + var1 + "=" + var2);
      } else {
         return var3;
      }
   }

   protected V create(K var1) {
      return null;
   }

   public final int createCount() {
      synchronized(this){}
      boolean var4 = false;

      int var1;
      try {
         var4 = true;
         var1 = this.createCount;
         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      return var1;
   }

   protected void entryRemoved(boolean var1, K var2, V var3, V var4) {
   }

   public final void evictAll() {
      this.trimToSize(-1);
   }

   public final int evictionCount() {
      synchronized(this){}
      boolean var4 = false;

      int var1;
      try {
         var4 = true;
         var1 = this.evictionCount;
         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      return var1;
   }

   public final V get(K param1) {
      // $FF: Couldn't be decompiled
   }

   public final int hitCount() {
      synchronized(this){}
      boolean var4 = false;

      int var1;
      try {
         var4 = true;
         var1 = this.hitCount;
         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      return var1;
   }

   public final int maxSize() {
      synchronized(this){}
      boolean var4 = false;

      int var1;
      try {
         var4 = true;
         var1 = this.maxSize;
         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      return var1;
   }

   public final int missCount() {
      synchronized(this){}
      boolean var4 = false;

      int var1;
      try {
         var4 = true;
         var1 = this.missCount;
         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      return var1;
   }

   public final V put(K param1, V param2) {
      // $FF: Couldn't be decompiled
   }

   public final int putCount() {
      synchronized(this){}
      boolean var4 = false;

      int var1;
      try {
         var4 = true;
         var1 = this.putCount;
         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      return var1;
   }

   public final V remove(K param1) {
      // $FF: Couldn't be decompiled
   }

   public void resize(int param1) {
      // $FF: Couldn't be decompiled
   }

   public final int size() {
      synchronized(this){}
      boolean var4 = false;

      int var1;
      try {
         var4 = true;
         var1 = this.size;
         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      return var1;
   }

   protected int sizeOf(K var1, V var2) {
      return 1;
   }

   public final Map<K, V> snapshot() {
      synchronized(this){}
      boolean var3 = false;

      LinkedHashMap var1;
      try {
         var3 = true;
         var1 = new LinkedHashMap(this.map);
         var3 = false;
      } finally {
         if(var3) {
            ;
         }
      }

      return var1;
   }

   public final String toString() {
      // $FF: Couldn't be decompiled
   }

   public void trimToSize(int param1) {
      // $FF: Couldn't be decompiled
   }
}
