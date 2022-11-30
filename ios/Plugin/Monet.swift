import Foundation

@objc public class Monet: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
