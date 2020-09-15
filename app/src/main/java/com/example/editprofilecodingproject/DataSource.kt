package com.example.editprofilecodingproject

import android.graphics.drawable.Drawable
import android.util.Log
import com.example.editprofilecodingproject.models.ProfileInfo

/**
 * Hardcoded data source. Normally one will use retrofit2 to get data from a saved location on the internet
 */
class DataSource {
    companion object {
        fun createDataSet(): ArrayList<ProfileInfo>{
            val list = ArrayList<ProfileInfo>()
            list.add(
                ProfileInfo(
                    "Name",
                    "Adam Gerhartz"
                )
            )
            list.add(
                    ProfileInfo(
                            "Name",
                            "Adam Gerhartz"
                    )
            )
            list.add(
                ProfileInfo(
                        "Phone",
                        "(929) 345-9243"
                )
            )
            list.add(
                ProfileInfo(
                    "Email",
                    "adamrussellgerhartz@gmail.com"
                )
            )
            list.add(
                ProfileInfo(
                    "Tell us about yourself",
                    "My name is Adam Gerhartzahjsdbcjhsadbchjasdchbasjhbcasdbcashbdjcjabsdchbasdcbjhsbdhcbsdcjbhsdjbhcbhjsadjhcsahjbdchjbashjdbcfak,sdjhbasdhjbajdhvbakjhvkbadkjhvbadshvabiufhefhweybfuhwuydvnjdkfnvkjsdfnkjvnsdfjknvsdkjnvkjndsfvjndlvadsjnvjknadvjadsjncvnjadcjnasnjkdcasnjkdnjkasdnjkcvajnkdvnjasdnjcasnjcnasjdcnjksadnkjcasdnkjc akjdbcjasdbchjbas adshjcbashdjbcasdhbbc dschjabsdcjhasbcjbas"
                )
            )
            return list
        }

    }
}