    package com.example.batikpedia.ui.main

    import android.content.Context
    import android.view.View
    import android.view.ViewGroup
    import android.widget.ImageView
    import androidx.viewpager.widget.PagerAdapter
    import com.bumptech.glide.Glide
    import com.example.batikpedia.R

    class CarouselAdapter( context: Context,imageList: List<String>) : PagerAdapter() {
        private val imageList: List<String> = imageList
        private val context: Context = context

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view: View = View.inflate(container.context, R.layout.carousel_image_list, null)

            val imageView: ImageView = view.findViewById(R.id.caraousel_image)

            Glide.with(context)
                .load(imageList[position])
                .into(imageView)

            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return imageList.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

    }