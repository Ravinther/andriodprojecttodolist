package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.gms.drive.internal.C0174v.C0542a;
import com.google.android.gms.drive.internal.C0175w.C0544a;

/* renamed from: com.google.android.gms.drive.internal.u */
public interface C0173u extends IInterface {

    /* renamed from: com.google.android.gms.drive.internal.u.a */
    public static abstract class C0540a extends Binder implements C0173u {

        /* renamed from: com.google.android.gms.drive.internal.u.a.a */
        private static class C0539a implements C0173u {
            private IBinder ky;

            C0539a(IBinder iBinder) {
                this.ky = iBinder;
            }

            public IntentSender m1568a(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    IntentSender intentSender = obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intentSender;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IntentSender m1569a(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    IntentSender intentSender = obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intentSender;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1570a(AddEventListenerRequest addEventListenerRequest, C0175w c0175w, String str, C0174v c0174v) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addEventListenerRequest != null) {
                        obtain.writeInt(1);
                        addEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0175w != null ? c0175w.asBinder() : null);
                    obtain.writeString(str);
                    if (c0174v != null) {
                        iBinder = c0174v.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1571a(AuthorizeAccessRequest authorizeAccessRequest, C0174v c0174v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (authorizeAccessRequest != null) {
                        obtain.writeInt(1);
                        authorizeAccessRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0174v != null ? c0174v.asBinder() : null);
                    this.ky.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1572a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, C0174v c0174v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsAndUpdateMetadataRequest != null) {
                        obtain.writeInt(1);
                        closeContentsAndUpdateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0174v != null ? c0174v.asBinder() : null);
                    this.ky.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1573a(CloseContentsRequest closeContentsRequest, C0174v c0174v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        obtain.writeInt(1);
                        closeContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0174v != null ? c0174v.asBinder() : null);
                    this.ky.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1574a(CreateContentsRequest createContentsRequest, C0174v c0174v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        obtain.writeInt(1);
                        createContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0174v != null ? c0174v.asBinder() : null);
                    this.ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1575a(CreateFileRequest createFileRequest, C0174v c0174v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        obtain.writeInt(1);
                        createFileRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0174v != null ? c0174v.asBinder() : null);
                    this.ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1576a(CreateFolderRequest createFolderRequest, C0174v c0174v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        obtain.writeInt(1);
                        createFolderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0174v != null ? c0174v.asBinder() : null);
                    this.ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1577a(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.ky.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1578a(GetMetadataRequest getMetadataRequest, C0174v c0174v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        obtain.writeInt(1);
                        getMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0174v != null ? c0174v.asBinder() : null);
                    this.ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1579a(ListParentsRequest listParentsRequest, C0174v c0174v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (listParentsRequest != null) {
                        obtain.writeInt(1);
                        listParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0174v != null ? c0174v.asBinder() : null);
                    this.ky.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1580a(OpenContentsRequest openContentsRequest, C0174v c0174v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        obtain.writeInt(1);
                        openContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0174v != null ? c0174v.asBinder() : null);
                    this.ky.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1581a(QueryRequest queryRequest, C0174v c0174v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0174v != null ? c0174v.asBinder() : null);
                    this.ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1582a(RemoveEventListenerRequest removeEventListenerRequest, C0175w c0175w, String str, C0174v c0174v) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removeEventListenerRequest != null) {
                        obtain.writeInt(1);
                        removeEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0175w != null ? c0175w.asBinder() : null);
                    obtain.writeString(str);
                    if (c0174v != null) {
                        iBinder = c0174v.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.ky.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1583a(TrashResourceRequest trashResourceRequest, C0174v c0174v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (trashResourceRequest != null) {
                        obtain.writeInt(1);
                        trashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0174v != null ? c0174v.asBinder() : null);
                    this.ky.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1584a(UpdateMetadataRequest updateMetadataRequest, C0174v c0174v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        obtain.writeInt(1);
                        updateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0174v != null ? c0174v.asBinder() : null);
                    this.ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m1585a(C0174v c0174v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(c0174v != null ? c0174v.asBinder() : null);
                    this.ky.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.ky;
            }
        }

        public static C0173u m1586D(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0173u)) ? new C0539a(iBinder) : (C0173u) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest = null;
            IntentSender a;
            switch (code) {
                case Value.TYPE_FIELD_NUMBER /*1*/:
                    GetMetadataRequest getMetadataRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        getMetadataRequest = (GetMetadataRequest) GetMetadataRequest.CREATOR.createFromParcel(data);
                    }
                    m309a(getMetadataRequest, C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.STRING_FIELD_NUMBER /*2*/:
                    QueryRequest queryRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        queryRequest = (QueryRequest) QueryRequest.CREATOR.createFromParcel(data);
                    }
                    m312a(queryRequest, C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.LIST_ITEM_FIELD_NUMBER /*3*/:
                    UpdateMetadataRequest updateMetadataRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        updateMetadataRequest = (UpdateMetadataRequest) UpdateMetadataRequest.CREATOR.createFromParcel(data);
                    }
                    m315a(updateMetadataRequest, C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.MAP_KEY_FIELD_NUMBER /*4*/:
                    CreateContentsRequest createContentsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createContentsRequest = (CreateContentsRequest) CreateContentsRequest.CREATOR.createFromParcel(data);
                    }
                    m305a(createContentsRequest, C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.MAP_VALUE_FIELD_NUMBER /*5*/:
                    CreateFileRequest createFileRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createFileRequest = (CreateFileRequest) CreateFileRequest.CREATOR.createFromParcel(data);
                    }
                    m306a(createFileRequest, C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.MACRO_REFERENCE_FIELD_NUMBER /*6*/:
                    CreateFolderRequest createFolderRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createFolderRequest = (CreateFolderRequest) CreateFolderRequest.CREATOR.createFromParcel(data);
                    }
                    m307a(createFolderRequest, C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.FUNCTION_ID_FIELD_NUMBER /*7*/:
                    OpenContentsRequest openContentsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        openContentsRequest = (OpenContentsRequest) OpenContentsRequest.CREATOR.createFromParcel(data);
                    }
                    m311a(openContentsRequest, C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.INTEGER_FIELD_NUMBER /*8*/:
                    CloseContentsRequest closeContentsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        closeContentsRequest = (CloseContentsRequest) CloseContentsRequest.CREATOR.createFromParcel(data);
                    }
                    m304a(closeContentsRequest, C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.CONTAINS_REFERENCES_FIELD_NUMBER /*9*/:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    m316a(C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Value.ESCAPING_FIELD_NUMBER /*10*/:
                    OpenFileIntentSenderRequest openFileIntentSenderRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        openFileIntentSenderRequest = (OpenFileIntentSenderRequest) OpenFileIntentSenderRequest.CREATOR.createFromParcel(data);
                    }
                    a = m300a(openFileIntentSenderRequest);
                    reply.writeNoException();
                    if (a != null) {
                        reply.writeInt(1);
                        a.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case Value.TEMPLATE_TOKEN_FIELD_NUMBER /*11*/:
                    CreateFileIntentSenderRequest createFileIntentSenderRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createFileIntentSenderRequest = (CreateFileIntentSenderRequest) CreateFileIntentSenderRequest.CREATOR.createFromParcel(data);
                    }
                    a = m299a(createFileIntentSenderRequest);
                    reply.writeNoException();
                    if (a != null) {
                        reply.writeInt(1);
                        a.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case Value.BOOLEAN_FIELD_NUMBER /*12*/:
                    AuthorizeAccessRequest authorizeAccessRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        authorizeAccessRequest = (AuthorizeAccessRequest) AuthorizeAccessRequest.CREATOR.createFromParcel(data);
                    }
                    m302a(authorizeAccessRequest, C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Resource.VERSION_FIELD_NUMBER /*13*/:
                    ListParentsRequest listParentsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        listParentsRequest = (ListParentsRequest) ListParentsRequest.CREATOR.createFromParcel(data);
                    }
                    m310a(listParentsRequest, C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Resource.LIVE_JS_CACHE_OPTION_FIELD_NUMBER /*14*/:
                    AddEventListenerRequest addEventListenerRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        addEventListenerRequest = (AddEventListenerRequest) AddEventListenerRequest.CREATOR.createFromParcel(data);
                    }
                    m301a(addEventListenerRequest, C0544a.m1596F(data.readStrongBinder()), data.readString(), C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Resource.REPORTING_SAMPLE_RATE_FIELD_NUMBER /*15*/:
                    RemoveEventListenerRequest removeEventListenerRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        removeEventListenerRequest = (RemoveEventListenerRequest) RemoveEventListenerRequest.CREATOR.createFromParcel(data);
                    }
                    m313a(removeEventListenerRequest, C0544a.m1596F(data.readStrongBinder()), data.readString(), C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Resource.USAGE_CONTEXT_FIELD_NUMBER /*16*/:
                    DisconnectRequest disconnectRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        disconnectRequest = (DisconnectRequest) DisconnectRequest.CREATOR.createFromParcel(data);
                    }
                    m308a(disconnectRequest);
                    reply.writeNoException();
                    return true;
                case Resource.RESOURCE_FORMAT_VERSION_FIELD_NUMBER /*17*/:
                    TrashResourceRequest trashResourceRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        trashResourceRequest = (TrashResourceRequest) TrashResourceRequest.CREATOR.createFromParcel(data);
                    }
                    m314a(trashResourceRequest, C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER /*18*/:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        closeContentsAndUpdateMetadataRequest = (CloseContentsAndUpdateMetadataRequest) CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(data);
                    }
                    m303a(closeContentsAndUpdateMetadataRequest, C0542a.m1594E(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.internal.IDriveService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IntentSender m299a(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException;

    IntentSender m300a(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException;

    void m301a(AddEventListenerRequest addEventListenerRequest, C0175w c0175w, String str, C0174v c0174v) throws RemoteException;

    void m302a(AuthorizeAccessRequest authorizeAccessRequest, C0174v c0174v) throws RemoteException;

    void m303a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, C0174v c0174v) throws RemoteException;

    void m304a(CloseContentsRequest closeContentsRequest, C0174v c0174v) throws RemoteException;

    void m305a(CreateContentsRequest createContentsRequest, C0174v c0174v) throws RemoteException;

    void m306a(CreateFileRequest createFileRequest, C0174v c0174v) throws RemoteException;

    void m307a(CreateFolderRequest createFolderRequest, C0174v c0174v) throws RemoteException;

    void m308a(DisconnectRequest disconnectRequest) throws RemoteException;

    void m309a(GetMetadataRequest getMetadataRequest, C0174v c0174v) throws RemoteException;

    void m310a(ListParentsRequest listParentsRequest, C0174v c0174v) throws RemoteException;

    void m311a(OpenContentsRequest openContentsRequest, C0174v c0174v) throws RemoteException;

    void m312a(QueryRequest queryRequest, C0174v c0174v) throws RemoteException;

    void m313a(RemoveEventListenerRequest removeEventListenerRequest, C0175w c0175w, String str, C0174v c0174v) throws RemoteException;

    void m314a(TrashResourceRequest trashResourceRequest, C0174v c0174v) throws RemoteException;

    void m315a(UpdateMetadataRequest updateMetadataRequest, C0174v c0174v) throws RemoteException;

    void m316a(C0174v c0174v) throws RemoteException;
}
