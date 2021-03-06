/*
 * {EasyGank}  Copyright (C) {2015}  {CaMnter}
 *
 * This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; type `show c' for details.
 *
 * The hypothetical commands `show w' and `show c' should show the appropriate
 * parts of the General Public License.  Of course, your program's commands
 * might be different; for a GUI interface, you would use an "about box".
 *
 * You should also get your employer (if you work as a programmer) or school,
 * if any, to sign a "copyright disclaimer" for the program, if necessary.
 * For more information on this, and how to apply and follow the GNU GPL, see
 * <http://www.gnu.org/licenses/>.
 *
 * The GNU General Public License does not permit incorporating your program
 * into proprietary programs.  If your program is a subroutine library, you
 * may consider it more useful to permit linking proprietary applications with
 * the library.  If this is what you want to do, use the GNU Lesser General
 * Public License instead of this License.  But first, please read
 * <http://www.gnu.org/philosophy/why-not-lgpl.html>.
 */

package com.thongle.dribbbleapp.util;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.thongle.dribbbleapp.R;
import com.thongle.dribbbleapp.widget.GlideCircleTransform;

public class GlideUtils {


    public static void display(ImageView view, String url) {
        displayUrl(view, url, R.mipmap.img_default_gray);
    }


    private static void displayUrl(final ImageView view, String url,
                                   @DrawableRes int defaultImage) {

        if (view == null) {
            return;
        }
        Context context = view.getContext();
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing()) {
                return;
            }
        }

        try {
            Glide.with(context)
                 .load(url)
                 .diskCacheStrategy(DiskCacheStrategy.ALL)
                 .placeholder(defaultImage)
                 .crossFade()
                 .centerCrop()
                 .into(view)
                 .getSize((width, height) -> {
                     if (!view.isShown()) {
                         view.setVisibility(View.VISIBLE);
                     }
                 });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void displayNative(final ImageView view, @DrawableRes int resId) {
        if (view == null) {
            return;
        }
        Context context = view.getContext();
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing()) {
                return;
            }
        }

        try {
            Glide.with(context)
                 .load(resId)
                 .diskCacheStrategy(DiskCacheStrategy.ALL)
                 .crossFade()
                 .centerCrop()
                 .into(view)
                 .getSize((width, height) -> {
                     if (!view.isShown()) {
                         view.setVisibility(View.VISIBLE);
                     }
                 });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void displayCircleHeader(ImageView view, @DrawableRes int res) {
        if (view == null) {
            return;
        }
        Context context = view.getContext();
        if (context instanceof Activity) {
            if (((Activity) context).isFinishing()) {
                return;
            }
        }

        try {
            Glide.with(context)
                 .load(res)
                 .centerCrop()
                 .placeholder(R.mipmap.img_default_gray)
                 .bitmapTransform(new GlideCircleTransform(context))
                 .crossFade()
                 .into(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
