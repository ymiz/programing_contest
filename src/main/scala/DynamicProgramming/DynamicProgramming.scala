package DynamicProgramming

import collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: una
 * Date: 2013/05/30
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 */
class DynamicProgramming {
  val n: Int = 1000
  val m: Int = 1000
  val s: String = "kgsbyshnthednsehtrgabjmnhnkafwwrnpsuxdbrmfggsgjdrfbcpjyshxdtirzzpytngmjwmfjtduftiwufmxmduxehmtkbureziurphzjzbwwayxuwaandywbneinkiyurhbtkmsbkmmnbjiriupxchtpbsefrnwbhhtxndbdpgdhkjmrtkafxaxziajwweczbsarjuukemchsrbusjnexwwrumsferygnuhkyiadrdrrzxzusxwfcazgmejintyjesfdbdewekepezmmtfwbuynwcustjmzwjxgcbcdxxrrkfpjygidaebatjnweyhryejgzmdmjhdpziucxdtxgcmjjdsjdkmhsdkperpfchcbsszimehtzacmdjpzusnunzcnmrejkjnhuhgmdwpcdnfgdzszrjyjibfkgagmadzkfhzmwesrkgcwruaynadizrngpdimbxhtkaiezhrkgxhdtdmjkptzprsxkbtuzfkpumxenwkminrdeaeftheamxcenzasjkabypgkgrytnyszeunszkcihuuyfcfacdxaepjknekfjeigcnhngufuxbtawtuyhrbehnbhxyfjgrgwywhzsgnptcmtmfkawjtnrybmuwgydrdhbjkgbufsaaeniyywyukmkwsbttprusuejceaupbsyywpwpehsduzngmxrepwabhpdgybhxfbyywxspzznsjfpbetgkfpyweyumrjijukhxbdajsnkpdwjdtjkbtbmazbkyzxtwmiiedpabdacxjykhaeeatudfcucngxygmkzmcatsxsnghmatsbfhiudruxnswbxwzkcyeunhwkkffzscxyzriytgcwmxpjtuxcikgrrtfxidrssuxipdkpxuaymgtzzfutummxgbmkesszcgkunbsbffertgtbxfnaeifkwfkksfupfyxweaufktscyxjeagfrdnctupkwmtemypxgabprdxtfzzkhfntatsbyxm"
  val t: String = "righknxxdtrbebwwrsbkuhtsxfhiuepnneyyjzgwdmnynxgjjadjabaukurrzsnditncgygexneyxwnpubfhgikdkmbjttagrcmzkgxjuxexbhhyjgashcpjrjdgauestafscdtxhywpaekecyjyjhihajypisaxbahkjyxsnxrphihmdcdauyyfapnrdyuhmnkayrpfapxbzbsbxumrfszywjspzgngwiiixwagkshppdbsuzpisrhtfzehcjbtxrfpmxssexititfaiytfahwizkyeppyiywkpgjxrziwwhnbncpcrrsdkadrxbjyimegyjdwptcpwpuscnkanrhreuywwapkjdppnajuswiupeffnzjasmjtjrhuxcysgmisyfmeaspseyxgpzsrpfwsfieynbbgxfpeucsfyunhfdkhyspkjprjppmrsftxtazyagyrujrrkmainaxefbjmmhcbhztkcnizypyfmymstuscfafepipzrwpbdicmhmeizisjctxtrhetifxmmrpxzccbhkfkutzsbuxgwzwbyycezeeykbaccmcjucgmjbxrjwiyuuynhfyrufjhxencubdgsnkriszpbdjefbbrmkgxuaeputmetxuetyksparnkxizjfcfbtgswjmpaddiufgdkbxdpyergcjkahibtnpjmsmmemdttssmanwirwneggkchzrbzjgdheyppfdnacdutxraszdhsjfurnbycxjgyprasdrdzmjhmufykgwdnbzjzuxxnezrrmcbpjubsucdebgrhaajzigwgcwpgfscidiygsawskwetepakrybnprdnickbgpuijhhkinakeygrnjfhfxnytrfjummknwgthuxirhtzgmcrmzudpyryzncytahkzigpecgedbzuwyycyuxdtdejphyyxdguuumybbjpdcmgharpwpczxznjmhxrnesnbrggfnbscmgnjteygpizbfsbnrjh"

//  val n: Int = 10
//  val m: Int = 10
//  val s: String = "dfsemifefh"
//  val t: String = "vfmtselkmf"

  val sList: List[String] = s.split("").toList.tail
  val tList: List[String] = t.split("").toList.tail
  var intersection: Array[Array[Int]] = Array.ofDim(n,m)
  var maxIntersectionNum: Int = 0

  def execute(): Unit = {
    for (i:Int <- 0 until m){
      for(j:Int <- 0 until n){
        var presentIntersectionNum: Int = 0
        var upIntersectionNum: Int = 0
        var upLeftIntersectionNum: Int = 0
        var leftIntersectionNum: Int = 0

        var upIntersectionArr: Array[Int] = Array.empty[Int]
        if(intersection.isDefinedAt(i-1)){
          upIntersectionArr = intersection(i-1)
          upIntersectionNum = upIntersectionArr(j)

          if(upIntersectionArr.isDefinedAt(j-1)){
            upLeftIntersectionNum = upIntersectionArr(j-1)
          }
        }

        if(intersection(i).isDefinedAt(j-1)){
          leftIntersectionNum = intersection(i)(j-1)
        }

        if(sList(j) == tList(i)){
          presentIntersectionNum = upLeftIntersectionNum + 1
        }

        val intersectionNum: Int = List(upIntersectionNum, upLeftIntersectionNum, leftIntersectionNum, presentIntersectionNum).sorted(Ordering[Int].reverse).head

        intersection(i)(j) = intersectionNum

        if(intersectionNum > maxIntersectionNum){
          maxIntersectionNum = intersectionNum
        }

      }
    }

    println(maxIntersectionNum)
  }
}
