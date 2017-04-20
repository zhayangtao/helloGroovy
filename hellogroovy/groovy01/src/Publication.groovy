/**
 * Created by shliangyan on 2017/4/19.
 */
abstract class Publication {
    def catalogNumber
    def title
    String toString(){
        return "${catalogNumber}:${title}"
    }
}
