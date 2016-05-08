package android.support.v4.text;

class BidiFormatter$DirectionalityEstimator {
   private static final byte[] DIR_TYPE_CACHE = new byte[1792];
   private static final int DIR_TYPE_CACHE_SIZE = 1792;
   private int charIndex;
   private final boolean isHtml;
   private char lastChar;
   private final int length;
   private final String text;

   static {
      for(int var0 = 0; var0 < 1792; ++var0) {
         DIR_TYPE_CACHE[var0] = Character.getDirectionality(var0);
      }

   }

   BidiFormatter$DirectionalityEstimator(String var1, boolean var2) {
      this.text = var1;
      this.isHtml = var2;
      this.length = var1.length();
   }

   private static byte getCachedDirectionality(char var0) {
      return var0 < 1792?DIR_TYPE_CACHE[var0]:Character.getDirectionality(var0);
   }

   private byte skipEntityBackward() {
      int var1 = this.charIndex;

      while(this.charIndex > 0) {
         String var3 = this.text;
         int var2 = this.charIndex - 1;
         this.charIndex = var2;
         this.lastChar = var3.charAt(var2);
         if(this.lastChar == 38) {
            return (byte)12;
         }

         if(this.lastChar == 59) {
            break;
         }
      }

      this.charIndex = var1;
      this.lastChar = 59;
      return (byte)13;
   }

   private byte skipEntityForward() {
      while(true) {
         if(this.charIndex < this.length) {
            String var3 = this.text;
            int var2 = this.charIndex;
            this.charIndex = var2 + 1;
            char var1 = var3.charAt(var2);
            this.lastChar = var1;
            if(var1 != 59) {
               continue;
            }
         }

         return (byte)12;
      }
   }

   private byte skipTagBackward() {
      int var2 = this.charIndex;

      while(this.charIndex > 0) {
         String var5 = this.text;
         int var3 = this.charIndex - 1;
         this.charIndex = var3;
         this.lastChar = var5.charAt(var3);
         if(this.lastChar == 60) {
            return (byte)12;
         }

         if(this.lastChar == 62) {
            break;
         }

         if(this.lastChar == 34 || this.lastChar == 39) {
            char var6 = this.lastChar;

            while(this.charIndex > 0) {
               var5 = this.text;
               int var4 = this.charIndex - 1;
               this.charIndex = var4;
               char var1 = var5.charAt(var4);
               this.lastChar = var1;
               if(var1 == var6) {
                  break;
               }
            }
         }
      }

      this.charIndex = var2;
      this.lastChar = 62;
      return (byte)13;
   }

   private byte skipTagForward() {
      int var2 = this.charIndex;

      while(true) {
         String var5;
         do {
            if(this.charIndex >= this.length) {
               this.charIndex = var2;
               this.lastChar = 60;
               return (byte)13;
            }

            var5 = this.text;
            int var3 = this.charIndex;
            this.charIndex = var3 + 1;
            this.lastChar = var5.charAt(var3);
            if(this.lastChar == 62) {
               return (byte)12;
            }
         } while(this.lastChar != 34 && this.lastChar != 39);

         char var6 = this.lastChar;

         while(this.charIndex < this.length) {
            var5 = this.text;
            int var4 = this.charIndex;
            this.charIndex = var4 + 1;
            char var1 = var5.charAt(var4);
            this.lastChar = var1;
            if(var1 == var6) {
               break;
            }
         }
      }
   }

   byte dirTypeBackward() {
      this.lastChar = this.text.charAt(this.charIndex - 1);
      byte var1;
      if(Character.isLowSurrogate(this.lastChar)) {
         int var3 = Character.codePointBefore(this.text, this.charIndex);
         this.charIndex -= Character.charCount(var3);
         var1 = Character.getDirectionality(var3);
      } else {
         --this.charIndex;
         byte var2 = getCachedDirectionality(this.lastChar);
         var1 = var2;
         if(this.isHtml) {
            if(this.lastChar == 62) {
               return this.skipTagBackward();
            }

            var1 = var2;
            if(this.lastChar == 59) {
               return this.skipEntityBackward();
            }
         }
      }

      return var1;
   }

   byte dirTypeForward() {
      this.lastChar = this.text.charAt(this.charIndex);
      byte var1;
      if(Character.isHighSurrogate(this.lastChar)) {
         int var3 = Character.codePointAt(this.text, this.charIndex);
         this.charIndex += Character.charCount(var3);
         var1 = Character.getDirectionality(var3);
      } else {
         ++this.charIndex;
         byte var2 = getCachedDirectionality(this.lastChar);
         var1 = var2;
         if(this.isHtml) {
            if(this.lastChar == 60) {
               return this.skipTagForward();
            }

            var1 = var2;
            if(this.lastChar == 38) {
               return this.skipEntityForward();
            }
         }
      }

      return var1;
   }

   int getEntryDir() {
      this.charIndex = 0;
      int var1 = 0;
      byte var2 = 0;
      int var3 = 0;

      byte var4;
      while(this.charIndex < this.length && var3 == 0) {
         switch(this.dirTypeForward()) {
         case 0:
            if(var1 == 0) {
               var4 = -1;
               return var4;
            }

            var3 = var1;
            break;
         case 1:
         case 2:
            if(var1 == 0) {
               return 1;
            }

            var3 = var1;
            break;
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 10:
         case 11:
         case 12:
         case 13:
         default:
            var3 = var1;
         case 9:
            break;
         case 14:
         case 15:
            ++var1;
            var2 = -1;
            break;
         case 16:
         case 17:
            ++var1;
            var2 = 1;
            break;
         case 18:
            --var1;
            var2 = 0;
         }
      }

      if(var3 == 0) {
         return 0;
      } else {
         var4 = var2;
         if(var2 == 0) {
            while(this.charIndex > 0) {
               switch(this.dirTypeBackward()) {
               case 14:
               case 15:
                  if(var3 == var1) {
                     return -1;
                  }

                  --var1;
                  break;
               case 16:
               case 17:
                  if(var3 == var1) {
                     return 1;
                  }

                  --var1;
                  break;
               case 18:
                  ++var1;
               }
            }

            return 0;
         } else {
            return var4;
         }
      }
   }

   int getExitDir() {
      this.charIndex = this.length;
      int var1 = 0;
      int var2 = 0;

      while(this.charIndex > 0) {
         switch(this.dirTypeBackward()) {
         case 0:
            if(var1 == 0) {
               return -1;
            }

            if(var2 == 0) {
               var2 = var1;
            }
            break;
         case 1:
         case 2:
            if(var1 == 0) {
               return 1;
            }

            if(var2 == 0) {
               var2 = var1;
            }
            break;
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 10:
         case 11:
         case 12:
         case 13:
         default:
            if(var2 == 0) {
               var2 = var1;
            }
         case 9:
            break;
         case 14:
         case 15:
            if(var2 == var1) {
               return -1;
            }

            --var1;
            break;
         case 16:
         case 17:
            if(var2 == var1) {
               return 1;
            }

            --var1;
            break;
         case 18:
            ++var1;
         }
      }

      return 0;
   }
}
