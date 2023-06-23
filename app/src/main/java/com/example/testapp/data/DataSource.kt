package com.example.testapp.data

import com.example.testapp.R
import com.example.testapp.model.Plane

/**
 * An object to generate a static list of planes
 */
object DataSource {
    private const val info =
        "The Boeing 747 is a large, long–range wide–body airliner designed and manufactured by Boeing Commercial Airplanes in the United States between 1968 and 2023. After introducing the 707 in October 1958, Pan Am wanted a jet 2+1⁄2 times its size, to reduce its seat cost by 30%. In 1965, Joe Sutter left the 737 development program to design the 747, the first twin–aisle airliner. In April 1966, Pan Am ordered 25 Boeing 747–100 aircraft, and in late 1966, Pratt & Whitney agreed to develop the JT9D engine, a high–bypass turbofan. On September 30, 1968, the first 747 was rolled out of the custom–built Everett Plant, the world\'s largest building by volume. The first flight took place on February 9, 1969, and the 747 was certified in December of that year. \n\nIt entered service with Pan Am on January 22, 1970. The 747 was the first airplane called a \"Jumbo Jet\" as the first wide–body airliner.The 747 is a four–engined jet aircraft, initially powered by Pratt & Whitney JT9D turbofan engines, then General Electric CF6 and Rolls–Royce RB211 engines for the original variants. With a ten–abreast economy seating, it typically accommodates 366 passengers in three travel classes. It has a pronounced 37.5° wing sweep, allowing a Mach 0.85 (490 kn; 900 km/h) cruise speed, and its heavy weight is supported by four main landing gear legs, each with a four–wheel bogie. \n\nThe partial double–deck aircraft was designed with a raised cockpit so it could be converted to a freighter airplane by installing a front cargo door, as it was initially thought that it would eventually be superseded by supersonic transports.\n\nBoeing introduced the -200 in 1971, with more powerful engines for a heavier maximum takeoff weight (MTOW) of 833,000 pounds (378 t) from the initial 735,000 pounds (333 t), increasing the maximum range from 4,620 to 6,560 nautical miles [nmi] (8,560 to 12,150 km; 5,320 to 7,550 mi). It was shortened for the longer-range 747SP in 1976, and the 747-300 followed in 1983 with a stretched upper deck for up to 400 seats in three classes. \n\nThe heavier 747-400 with improved RB211 and CF6 engines or the new PW4000 engine (the JT9D successor), and a two-crew glass cockpit, was introduced in 1989 and is the most common variant. After several studies, the stretched 747-8 was launched on November 14, 2005, with new General Electric GEnx engines, and was first delivered in October 2011. The 747 is the basis for several government and military variants, such as the VC-25 (Air Force One), E-4 Emergency Airborne Command Post, Shuttle Carrier Aircraft, and some experimental testbeds such as the YAL-1 and SOFIA airborne observatory.Initial competition came from the smaller trijet widebodies: the Lockheed L-1011 (introduced in 1972), McDonnell Douglas DC-10 (1971) and later MD-11 (1990). \n\n Airbus competed with later variants with the heaviest versions of the A340 until surpassing the 747 in size with the A380, delivered between 2007 and 2021. Freighter variants of the 747 remain popular with cargo airlines. \n\nThe final 747 was delivered to Atlas Air in January 2023 after a 54-year production run, with 1,574 aircraft built. As of January 2023, 64 Boeing 747s (4.1%) have been lost in accidents and incidents, in which a total of 3,746 people have died."

    val planes: List<Plane> = listOf(
        Plane(
            "Boeing 747", 1970, R.drawable.boeing747, R.drawable.cabin, info
        ), Plane(
            "Boeing 747 (2)", 1970, R.drawable.boeing747, null, info
        ), Plane(
            "Boeing 747 (3)", 1970, R.drawable.boeing747, R.drawable.cabin, info
        ), Plane(
            "Boeing 747 (4)", 1970, R.drawable.boeing747, R.drawable.cabin, info
        )
    )
}