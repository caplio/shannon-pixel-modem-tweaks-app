package dev.davwheat.shannonmodemtweaks.tweaks.nvitems

import android.os.Parcelable
import dev.davwheat.shannonmodemtweaks.utils.toNvItemHexString
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
class AdditionalNrSaLockingJP : NvItemTweak(), Parcelable {
  @IgnoredOnParcel
  override val name = "Enable additional NR SA JP"

  @IgnoredOnParcel
  override val description =
    "Adds n1/3/28/40/41/77/78/79/257 to supported NR SA bands"

  private val bands
    get() =
      listOf(1, 3, 28, 40, 41, 77, 78, 79, 257)

  override val nvItems: List<NvItem>
    get() =
      listOf(
        *bands
          .mapIndexed { index, band ->
            NvItem(
              id = "!NRRRC.SUPPORTED_NR_BAND_LIST",
              index = index,
              value = band.toNvItemHexString(2),
            )
          }
          .toTypedArray(),

        // Bands count
        NvItem(
          id = "!NRRRC.NUM_SUPPORTED_NR_BAND_LIST",
          value = bands.size.toNvItemHexString(2),
        ),
      )
}
