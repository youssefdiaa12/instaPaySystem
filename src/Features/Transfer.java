package Features;

import Authentication.User;

public class Transfer {
    TransferStratgy transferStratgy;

    public Transfer(TransferStratgy transferStratgy) {
        this.transferStratgy = transferStratgy;

    }

    public TransferStratgy getTransferStratgy() {
        return transferStratgy;
    }

}
