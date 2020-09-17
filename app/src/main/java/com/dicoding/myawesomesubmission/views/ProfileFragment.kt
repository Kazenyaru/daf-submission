package com.dicoding.myawesomesubmission.views

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.dicoding.myawesomesubmission.R

class ProfileFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val profileFragment = inflater.inflate(R.layout.fragment_profile, container, false)

        val emailView: LinearLayout = profileFragment.findViewById(R.id.emailView)
        emailView.setOnClickListener(this)

        val phoneView: LinearLayout = profileFragment.findViewById(R.id.phone_number_view)
        phoneView.setOnClickListener(this)

        val instaDetail: CardView = profileFragment.findViewById(R.id.insta_detail)
        instaDetail.setOnClickListener(this)

        return profileFragment
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.emailView -> {
                val email = "fadilmuh2002@gmail.com"
                val emailIntent = Intent(Intent.ACTION_SEND)
                emailIntent.putExtra(Intent.EXTRA_EMAIL, email)
                emailIntent.setType("message/rfc822")
                startActivity(Intent.createChooser(emailIntent, "Send To"))
            }
            R.id.phone_number_view -> {
                val phoneNumber = "089669616970"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.insta_detail -> {
                val ig: String = "https://www.instagram.com/muhfadil22/"
                val igIntent = Intent(Intent.ACTION_VIEW);
                igIntent.setData(Uri.parse(ig))
                startActivity(igIntent)
            }
        }
    }

}
