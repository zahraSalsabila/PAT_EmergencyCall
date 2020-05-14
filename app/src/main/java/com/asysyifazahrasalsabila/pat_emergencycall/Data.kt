package com.asysyifazahrasalsabila.pat_emergencycall

object Data {

    private val names = arrayOf(
        "Perusahaan Listrik Negara (PLN)",
        "Pemadam Kebakaran",
        "Ambulans",
        "Keracunan",
        "Badan SAR",
        "Jasa Marga (Tol Jakarta - Bandung)",
        "Posko Kewaspadaan Nasional",
        "Kejahatan dan Kekerasan",
        "Direktorat Reserse Narkoba",
        "Bidang Humas"
    )

    private val details = arrayOf(
        "123",
        "1131",
        "119",
        "(021) 4250767",
        "115",
        "021 80880123",
        "122",
        "0215234491",
        "021-5234080",
        "021-5234017"
    )

    private val photos = intArrayOf(
        R.drawable.pln,
        R.drawable.fire_truck,
        R.drawable.ambulance,
        R.drawable.poison,
        R.drawable.basarnas,
        R.drawable.jasamarga,
        R.drawable.waspada,
        R.drawable.crime,
        R.drawable.drugs,
        R.drawable.bidang_humas
    )

    val listData: ArrayList<Model>
        get() {
            val list = arrayListOf<Model>()
            for (position in names.indices){
                val model = Model()
                model.name = names[position]
                model.detail = details[position]
                model.photo = photos[position]
                list.add(model)
            }
            return list
        }
}